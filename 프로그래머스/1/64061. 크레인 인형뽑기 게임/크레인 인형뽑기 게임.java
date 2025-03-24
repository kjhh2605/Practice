import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer>[] line = new Stack[n];

        for (int i = 0; i < n; i++) {
            line[i] = new Stack<>();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                int a = board[i][j];
                if (a != 0) {
                    line[j].push(a);  
                }
            }
        }

        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            int a = move - 1;

            if(line[a].isEmpty())
                continue;

            int doll = line[a].pop();
            if (!basket.isEmpty() && basket.peek() == doll) {
                basket.pop();
                answer += 2; 
            } else {
                basket.push(doll);
            }
        }

        return answer;
    }
}
