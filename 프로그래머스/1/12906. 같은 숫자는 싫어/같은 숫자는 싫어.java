import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for(int i = 1 ; i < arr.length ; i++){
            if(s.peek()!=arr[i])
                s.push(arr[i]);
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}