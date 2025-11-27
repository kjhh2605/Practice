import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int maxDiff = 0;
        for(int i : diffs){
            maxDiff = Math.max(maxDiff, i);
        }
        
        int start = 1;  
        int end = maxDiff;
        
        while(start <= end){
            int mid = (start + end) / 2;
            long totalTime = times[0];
            boolean possible = true;
            
            for(int i = 1; i < times.length; i++){
                if(diffs[i] <= mid){
                    totalTime += times[i];
                } else {
                    totalTime += (long)(diffs[i] - mid) * (times[i] + times[i-1]) + times[i];
                }
                
                if(totalTime > limit){
                    possible = false;
                    break;
                }
            }
            
            if(possible){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}