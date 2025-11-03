import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int ans = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(map[i][j] == 'L'){
                    q.clear();
                    for(boolean[] b : visited){
                        Arrays.fill(b, false);
                    }

                    q.add(new int[]{j,i});
                    visited[i][j] = true;

                    int dist = -1;
                    while(!q.isEmpty()){
                        int size = q.size();
                        dist++;
                        for(int p = 0 ; p < size ; p++) {
                            int[] cur = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];

                                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx] || map[ny][nx] == 'W')
                                    continue;

                                visited[ny][nx] = true;
                                q.add(new int[]{nx, ny});

                            }
                        }
                    }
                    ans = Math.max(ans, dist);
                }
            }
        }

        System.out.println(ans);
    }
}