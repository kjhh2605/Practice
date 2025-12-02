import java.util.HashSet;

class Solution {
    int[][] q ;
    int[] ans;
    int n;
    int answer;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        this.q = q;
        this.ans = ans;
        this.n = n;

        dfs(1, new HashSet<Integer>());

        return answer;
    }

    void dfs(int start, HashSet<Integer> list){
        if(list.size()==5){
            for(int i = 0 ; i < q.length ; i++){
                int c = 0;
                for(int j = 0 ; j < 5 ; j++){
                    if(list.contains(q[i][j])){
                        c++;
                    }
                }
                if(ans[i] != c){
                    return;
                }
            }
            answer++;
            return;
        }
        for(int i = start ; i <= n ; i++){
            list.add(i);
            dfs(i+1,list);
            list.remove(i);
        }
    }
}