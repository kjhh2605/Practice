import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(numbers[0]);
        q.add(numbers[0]*(-1));
        for(int j = 1 ; j < numbers.length ; j++){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int cur = q.poll();
                q.add(cur+numbers[j]);
                q.add(cur+numbers[j]*(-1)); 
            }
        }
        for(Integer i : q){
            if(i==target)
                answer++;
        }
        return answer;
    }
}