import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 세로
        int m = maps[0].length; // 가로 

        int[] cur = {0, 0}; // {y, x}
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(cur);
        visited[0][0] = true;

        int cnt = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                cur = q.poll();
                int cury = cur[0];
                int curx = cur[1];

                if (curx == m - 1 && cury == n - 1)
                    return cnt;

                for (int j = 0; j < 4; j++) {
                    int x = curx + dx[j];
                    int y = cury + dy[j];

                    if (x < 0 || y < 0 || x >= m || y >= n || maps[y][x] == 0 || visited[y][x])
                        continue;

                    visited[y][x] = true;
                    q.add(new int[]{y, x});
                }
            }
            cnt++;
        }

        return -1;
    }
}
