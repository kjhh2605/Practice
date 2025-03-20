import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]%divisor == 0){
                a.add(arr[i]);
            }
        }
        if(a.size()==0)
            return new int[]{-1};
        answer = a.stream().sorted().mapToInt(i->i).toArray();
        return answer;
    }
}