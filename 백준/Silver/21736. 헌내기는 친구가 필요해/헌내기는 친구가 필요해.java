import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        char[][] map = new char[n][m]; // char 배열 사용
        boolean[][] visited = new boolean[n][m];

        ArrayDeque<int[]> search = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
                if (row[j] == 'I') {
                    search.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int cnt = 0;

        while (!search.isEmpty()) {
            int[] cur = search.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if (map[nx][ny] == 'O' || map[nx][ny] == 'P') {
                    search.add(new int[]{nx, ny});
                    if (map[nx][ny] == 'P') cnt++;
                }
            }
        }

        System.out.println(cnt > 0 ? cnt : "TT");
    }
}
