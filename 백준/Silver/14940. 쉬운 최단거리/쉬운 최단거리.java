import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] map = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque();
        for(int i = 0 ; i < n ; i++){
            line = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        int[][] answer = new int[n][m];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0) {
                int[] cur = q.poll();

                if (!visited[cur[0]][cur[1]]) { // 첫 방문이면
                    answer[cur[0]][cur[1]] = cnt;
                    visited[cur[0]][cur[1]] = true;
                }else{
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int x = cur[1] + dx[i];
                    int y = cur[0] + dy[i];
                    if (x < 0 || y < 0 || x >= m || y >= n || map[y][x] == 0)
                        continue;
                    else
                        q.add(new int[]{y,x});
                }
            }
            cnt++;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(answer[i][j] == 0 && map[i][j]==1)
                    sb.append(-1).append(" ");
                else
                    sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
