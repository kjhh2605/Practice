import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long k = 0;
        
        for (int i = 0; i < n; i++) {
            k += queue1[i] + queue2[i];
        }
        
        k /= 2;
        
        int[] arr1 = new int[n*2];
        int[] arr2 = new int[n*2];
        for (int i = 0; i < n; i++) {
            arr1[i] = queue1[i];
            arr1[n+i] = queue2[i];
            arr2[i] = queue2[i];
            arr2[n+i] = queue1[i];
        }
        
        int result = Math.min(tp(k, arr2, n),tp(k, arr1, n));
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public int tp(long k, int[] arr, int n) {
        int start = 0;
        int end = n;
        long sum = 0;
        
        // 애초에 가능한 경우
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }        
        if (sum == k){
            return 0;
        }
        
        while (start <= end && end < arr.length) {
            if (sum < k) {
                sum += arr[end];
                end++;
            } else if (sum > k) {
                sum -= arr[start];
                start++;
            } else {
                return start + (end - n);
            }
        }
        
        return Integer.MAX_VALUE;
    }
}