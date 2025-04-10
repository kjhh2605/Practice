import java.util.*;

class Solution {
    class My {
        int x, y, cost, direction;

        public My(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costMap = new int[n][n][4]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costMap[i][j], Integer.MAX_VALUE);
            }
        }

        ArrayDeque<My> q = new ArrayDeque<>();
        q.add(new My(0, 0, 0, -1)); 

        int[] dx = {0, 0, 1, -1}; 
        int[] dy = {1, -1, 0, 0}; 

        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            My cur = q.poll();
            
            if (cur.x == n - 1 && cur.y == n - 1) {
                answer = Math.min(answer, cur.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= n || newY >= n || board[newX][newY] == 1) {
                    continue;
                }

                int newCost = cur.cost;
                if (cur.direction == -1 || cur.direction == i) { 
                    newCost += 100;
                } else { 
                    newCost += 600;
                }
                
                if (newCost < costMap[newX][newY][i]) {
                    costMap[newX][newY][i] = newCost;
                    q.add(new My(newX, newY, newCost, i));
                }
            }
        }

        return answer;
    }
}
