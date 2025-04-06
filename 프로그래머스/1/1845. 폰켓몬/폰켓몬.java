import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        HashSet<Integer>h = new HashSet<>();
        for(int i : nums){
            h.add(i);
        }
        
        return h.size()>n/2?n/2:h.size();
    }
}