import java.util.*;
class Solution {
    public int n;
    public int target;
    public int[] info;
    public int[] lion;
    public int scoreL;
    public int scoreA;
    public int[] answer = new int[]{-1};
    public int gap = 0;
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        this.lion = new int[11];
        dfs(0,0);
        return answer;
    }
    public void dfs(int arrowCnt,int k){
        if(k==11){
            lion[10] = n-arrowCnt;
            if(lionIsWin(info,lion)){
                int tmp = scoreL - scoreA;
                if (tmp > gap) {
                    gap = tmp;
                    answer = lion.clone();
                } else if (tmp == gap) {
                    boolean flag = false;
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] > answer[i]) {
                            flag = true;
                            break;
                        }else if(lion[i] < answer[i]){
                            flag = false;
                            break;
                        } 
                    }
                    if(flag)
                        answer = lion.clone();
                }
            }
            lion[10] = 0;
            return;
        }

        if(n-arrowCnt > info[k]){ 
            lion[k] = info[k]+1;
            dfs(arrowCnt+info[k]+1,k+1);
            lion[k] = 0;
        }
        dfs(arrowCnt,k+1);
    }
    public boolean lionIsWin(int[] info, int[] lion){
        int scoreL = 0;
        int scoreA = 0;
        for(int i = 0 ; i < info.length ; i++){
            if(info[i]==0 && lion[i]==0){
                continue;
            }else if(info[i] >= lion[i]){
                scoreA+=10-i;
            }else{
                scoreL+=10-i;
            }
        }
        this.scoreL = scoreL;
        this.scoreA = scoreA;

        return scoreL>scoreA;
    }
}