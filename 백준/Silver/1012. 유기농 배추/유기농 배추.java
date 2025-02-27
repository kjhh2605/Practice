import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String[] line = br.readLine().split(" ");
            int rows = Integer.parseInt(line[0]);
            int cols = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);
            int[][] m = new int[rows][cols];
            ArrayDeque<int[]> list = new ArrayDeque<>();
            for(int i = 0; i < k ; i++){
                String[] l = br.readLine().split(" ");
                int a = Integer.parseInt(l[0]);
                int b = Integer.parseInt(l[1]);
                m[a][b] = 1;
                list.add(new int[]{a,b});
            }
            boolean[][] visited = new boolean[rows][cols];
            int cnt = 0;
            int[] dx = {0,0,-1,1};
            int[] dy = {-1,1,0,0};
            while(!list.isEmpty()){
                int[] cur = list.poll();
                int x = cur[0];
                int y = cur[1];
                if(visited[x][y])
                    continue;
                else
                    visited[x][y] = true;

                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.add(cur);
                while(!q.isEmpty()){
                    int[] now = q.poll();
                    int cx = now[0];
                    int cy = now[1];

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];

                        if (nx < 0 || nx >= rows || ny < 0 || ny >= cols)
                            continue;
                        if (m[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                cnt++;
            }
            System.out.println(cnt);

        }
    }
}
