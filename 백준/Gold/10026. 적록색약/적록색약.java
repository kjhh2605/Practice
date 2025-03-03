import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] checked;

    public static int bfs(char[][] grid, ArrayDeque<int[]> graph, int n) {
        checked = new boolean[n][n];  // 전역 변수 재사용
        int cnt = 0;

        while (!graph.isEmpty()) {
            int[] cur = graph.poll();
            int x = cur[0];
            int y = cur[1];

            if (checked[x][y]) continue;

            ArrayDeque<int[]> search = new ArrayDeque<>();
            search.add(cur);
            char c = grid[x][y];
            checked[x][y] = true;

            while (!search.isEmpty()) {
                int[] tmp = search.poll();
                int curX = tmp[0];
                int curY = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || checked[nx][ny])
                        continue;
                    if (grid[nx][ny] != c) continue;

                    search.add(new int[]{nx, ny});
                    checked[nx][ny] = true;
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        char[][] grid2 = new char[n][n];
        ArrayDeque<int[]> q1 = new ArrayDeque<>();
        ArrayDeque<int[]> q2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                grid[i][j] = c;
                if (c == 'G')
                    grid2[i][j] = 'R';
                else
                    grid2[i][j] = c;
                q1.add(new int[]{i, j});
                q2.add(new int[]{i, j});
            }
        }
        System.out.println(bfs(grid, q1, n) + " " + bfs(grid2, q2, n));
    }
}
