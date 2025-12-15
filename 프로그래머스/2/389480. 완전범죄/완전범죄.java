import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 
        
        for(int i = 0; i < info.length; i++){
            int a = info[i][0];
            int b = info[i][1];
            
            int[] tmp = new int[m];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            
            for(int j = 0; j < m; j++){
                
                if(dp[j] == Integer.MAX_VALUE){
                    continue;
                }

                if(dp[j] + a < n){
                    tmp[j] = Math.min(dp[j] + a, tmp[j]);
                }
                
                if(j + b < m){
                    tmp[j + b] = Math.min(tmp[j + b], dp[j]);
                }
            }
            dp = tmp;
        }
        
        for(int i : dp){
            answer = Math.min(answer, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}