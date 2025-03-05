import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]); // x
        int m = Integer.parseInt(line[1]); // y
        int h = Integer.parseInt(line[2]); // z

        int[][][] box = new int[h][m][n];

        ArrayDeque<int[]> q = new ArrayDeque<>();

        int target = 0;
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < m ; j++){
                line = br.readLine().split(" ");
                for(int k = 0; k < n ; k++){
                    int tmp = Integer.parseInt(line[k]);
                    box[i][j][k] = tmp;
                    if(tmp == 1)
                        q.add(new int[]{i,j,k}); // z,y,x
                    if(tmp == 0)
                        target++;
                }
            }
        }
        if(target == 0){
            System.out.println(0);
            return;
        }

        int[] dx = {0,0,1,-1,0,0};
        int[] dy = {1,-1,0,0,0,0};
        int[] dz = {0,0,0,0,1,-1};

        int cnt = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int a = 0 ; a < size ; a++) {
                int[] cur = q.poll();
                int z = cur[0];
                int y = cur[1];
                int x = cur[2];
                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m)
                        continue;

                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        target--;
                        q.add(new int[]{nz, ny, nx});
                    }
                }
            }
            cnt++;
        }

        System.out.println(target>0?-1:cnt);
    }
}
