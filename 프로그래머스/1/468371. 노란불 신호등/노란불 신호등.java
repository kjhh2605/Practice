import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int[] cycle = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            start[i] = signals[i][0]+1;
            end[i] = signals[i][0]+signals[i][1];
            cycle[i] = signals[i][0]+signals[i][1]+signals[i][2];
        }
    
        int limit = Arrays.stream(cycle).reduce(1, (a, b) -> a * b);
        
        flag:
        for(answer = 1 ; answer < limit  ; answer++){
            for(int i = 0 ; i < n ; i++){
                int t = answer%cycle[i];
                if(t <= end[i] && t >= start[i]){
                    
                }else{
                    continue flag;
                }
            }
            return answer;
        }
        
        return -1;
    }
}