import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        int[] list = new int[elements.length*2];
        for(int i = 0 ; i < elements.length ; i++){
            list[i] = elements[i];
            list[i+elements.length] = elements[i];
        }
        
        Set<Integer> h = new HashSet<>();
        
        for(int i = 1; i < elements.length+1 ; i++){ // i = 부분 배열 길이
            for(int idx = 0 ; idx < elements.length ; idx++){ // idx = 시작
                int sum = 0;
                for(int k = 0 ; k < i ; k++){
                    sum += list[idx+k];
                }
                h.add(sum);
            }
        }
        
        return h.size();
    }
}