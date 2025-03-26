import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        // 가격을 하나씩 처리
        for (int i = 0; i < prices.length; i++) {
            // 현재 가격이 떨어지면
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop(); // 떨어진 가격의 인덱스
                answer[index] = i - index; // 가격이 떨어지기까지의 시간 기록
            }
            stack.push(i); // 현재 인덱스를 스택에 추가
        }
        
        // 스택에 남은 인덱스는 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1; // 마지막 가격까지의 시간 계산
        }
        
        return answer;
    }
}
