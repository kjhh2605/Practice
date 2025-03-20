import java.util.*;
class Solution {
    public int[] solution(int N, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        long num = left; 
        for (int i = 0; i < answer.length; i++) {
            int x = (int) (num % N);
            int y = (int) (num / N);
            answer[i] = Math.max(y, x) + 1;
            num++;
        }
        
        return answer;
        
    }
}