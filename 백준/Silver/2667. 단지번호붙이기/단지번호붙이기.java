import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] checked = new boolean[n][n];
        String[] line;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        ArrayList<Integer> answer = new ArrayList<>();
        int count = 0;
        while (!q.isEmpty()) {
            int cnt = 0;
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (checked[x][y])
                continue;
            ArrayDeque<int[]> qq = new ArrayDeque<>();
            qq.add(cur);
            while (!qq.isEmpty()) {
                int[] cr = qq.poll();
                int X = cr[0];
                int Y = cr[1];
                if (checked[X][Y])
                    continue;
                else
                    checked[X][Y] = true;
                cnt++;
                for (int i = 0; i < 4; i++) {
                    int cX = X + dx[i];
                    int cY = Y + dy[i];
                    if (cX < 0 || cY < 0 || cX >= n || cY >= n || checked[cX][cY] || map[cX][cY] != 1)
                        continue;

                    qq.add(new int[]{cX, cY});
                    checked[cX][cY] = false;
                }
            }
            answer.add(cnt);
            count++;
        }
        System.out.println(count);
        answer.sort(null);
        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
