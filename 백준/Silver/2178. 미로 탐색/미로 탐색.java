import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++){
            line = br.readLine().split("");
            for(int j = 0; j < m; j++){
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }
        int cnt = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{0,0});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        a:
        while (true) {
            cnt++;
            int t = q.size();
            for(int k = 0; k < t; k++) {
                int[] cur = q.poll();
                if (visited[cur[0]][cur[1]])
                    continue;
                else
                    visited[cur[0]][cur[1]] = true;

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        int x = cur[0] + dx[j];
                        int y = cur[1] + dy[j];

                        if (x == n - 1 && y == m - 1)
                            break a;

                        if (x < 0 || x >= n || y < 0 || y >= m || maze[x][y] == 0)
                            continue;
                        else {
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        System.out.println(cnt+1);
    }
}
