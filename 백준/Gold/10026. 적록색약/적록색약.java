import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        ArrayDeque<int[]> q = new ArrayDeque();
        ArrayDeque<int[]> qq = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = s.charAt(j);
                q.add(new int[]{i, j});
                qq.add(new int[]{i, j});

            }
        }

        boolean[][] checked = new boolean[n][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (checked[x][y])
                continue;
            else
                checked[x][y] = true;

            ArrayDeque<int[]> search = new ArrayDeque<>();
            search.add(cur);
            char c = grid[x][y];
            while (!search.isEmpty()) {
                int[] tmp = search.poll();
                int curX = tmp[0];
                int curY = tmp[1];
                for (int i = 0; i < 4; i++) {
                    if (curX + dx[i] < 0 || curY + dy[i] < 0 || curX + dx[i] >= n || curY + dy[i] >= n)
                        continue;
                    if (c == 'B') {
                        if (checked[curX + dx[i]][curY + dy[i]] || grid[curX + dx[i]][curY + dy[i]] != c)
                            continue;
                        else {
                            search.add(new int[]{curX + dx[i], curY + dy[i]});
                            checked[curX + dx[i]][curY + dy[i]] = true;
                        }
                    } else {
                        if (checked[curX + dx[i]][curY + dy[i]] || grid[curX + dx[i]][curY + dy[i]] == 'B')
                            continue;
                        else {
                            search.add(new int[]{curX + dx[i], curY + dy[i]});
                            checked[curX + dx[i]][curY + dy[i]] = true;
                        }
                    }
                }
            }
            cnt++;
        }

        boolean checked1[][] = new boolean[n][n];
        int count = 0;
        while (!qq.isEmpty()) {
            int[] cur = qq.poll();
            int x = cur[0];
            int y = cur[1];

            if (checked1[x][y])
                continue;
            else
                checked1[x][y] = true;

            ArrayDeque<int[]> search = new ArrayDeque<>();
            search.add(cur);
            char c = grid[x][y];
            while (!search.isEmpty()) {
                int[] tmp = search.poll();
                int curX = tmp[0];
                int curY = tmp[1];
                for (int i = 0; i < 4; i++) {
                    if (curX + dx[i] < 0 || curY + dy[i] < 0 || curX + dx[i] >= n || curY + dy[i] >= n)
                        continue;
                    if (checked1[curX + dx[i]][curY + dy[i]] || grid[curX + dx[i]][curY + dy[i]] != c)
                        continue;
                    else {
                        search.add(new int[]{curX + dx[i], curY + dy[i]});
                        checked1[curX + dx[i]][curY + dy[i]] = true;
                    }
                }
            }
            count++;
        }
        System.out.println(count+" "+cnt);
    }
}
