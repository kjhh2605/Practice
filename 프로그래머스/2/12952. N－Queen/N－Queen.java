import java.util.*;

class Solution {
    public int answer;
    
    public int solution(int n) {
        boolean[] visitedColumns = new boolean[n];
        boolean[] visitedDiag1 = new boolean[2 * n - 1]; 
        boolean[] visitedDiag2 = new boolean[2 * n - 1]; 
        dfs(0, visitedColumns, visitedDiag1, visitedDiag2, n);
        return answer;
    }

    public void dfs(int row, boolean[] visitedColumns, boolean[] visitedDiag1, boolean[] visitedDiag2, int n) {
        if (row == n) {  
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!visitedColumns[col] && !visitedDiag1[row + col] && !visitedDiag2[row - col + n - 1]) {

                visitedColumns[col] = true;
                visitedDiag1[row + col] = true;
                visitedDiag2[row - col + n - 1] = true;


                dfs(row + 1, visitedColumns, visitedDiag1, visitedDiag2, n);


                visitedColumns[col] = false;
                visitedDiag1[row + col] = false;
                visitedDiag2[row - col + n - 1] = false;
            }
        }
    }
}
