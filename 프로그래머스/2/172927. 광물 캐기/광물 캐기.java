import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int diaCnt = picks[0]; // 항상 best
        int ironCnt = picks[1]; // 다이아 제외 best
        int stoneCnt = picks[2]; // wort
        
        int groupCnt = minerals.length / 5;
        if(minerals.length%5!=0){
            groupCnt+=1;
        }
        
        int totalPicks = diaCnt + ironCnt + stoneCnt;
        
        groupCnt = Math.min(groupCnt, totalPicks);
        
        int[][] check = new int[groupCnt][3];
        
        for(int i = 0 ; i < groupCnt; i++){
            for(int j = 0 ; j  < 5 && i*5+j < minerals.length; j++){
                if(minerals[i*5+j].equals("diamond")){
                    check[i][0]++;
                }else if(minerals[j+i*5].equals("iron")){
                    check[i][1]++;
                }else{
                    check[i][2]++;
                }
            }
        }
        
        Arrays.sort(check, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return b[0] - a[0]; 
                if (a[1] != b[1]) return b[1] - a[1]; 
                return b[2] - a[2];
            }
        });
        
        for (int i = 0; i < groupCnt; i++) {
            int d = check[i][0];
            int ir = check[i][1];
            int st = check[i][2];

            if (diaCnt > 0) {        
                answer += d + ir + st;
                diaCnt--;
            } else if (ironCnt > 0) {    
                answer += d * 5 + ir + st;
                ironCnt--;
            } else if (stoneCnt > 0) {  
                answer += d * 25 + ir * 5 + st;
                stoneCnt--;             
            } else {
                break;                  
            }
        }
        
        return answer;
    }
}