import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(i%2==0){
                a[i] = sequence[i]; 
                b[i] = sequence[i]*(-1);
            }else{
                a[i] = sequence[i]*(-1); 
                b[i] = sequence[i];
            }
        }
        
        
        return Math.max(search(a),search(b));
    }
    
    public long search(int[] array){
        long cur = 0;
        long ans = 0;
    
        for(int a : array){
            cur += a;
            if(cur > ans){
                ans = cur;
            }
            if(cur < 0){
                cur = 0;
            }
        }
        
        return ans;
    }
}