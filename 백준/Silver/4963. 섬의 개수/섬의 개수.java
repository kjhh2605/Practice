import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[][] visited;
    public static int[] dx = {0,0,1,-1,1,1,-1,-1};
    public static int[] dy = {1,-1,0,0,1,-1,-1,1};
    public static void bfs(int[][] map , int[] p){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(p);
        visited[p[0]][p[1]] = true;
        while(!q.isEmpty()){
            int[]cur = q.poll();
            int x = cur[1];
            int y = cur[0];
            for(int i = 0 ; i < 8 ; i++){
                int curX = x+dx[i];
                int curY = y+dy[i];
                if(curX < 0 || curY < 0 || curX >= map[0].length || curY >= map.length || visited[curY][curX])
                    continue;
                if(map[curY][curX] == 1 ) {
                    q.add(new int[]{curY, curX});
                    visited[curY][curX] = true;
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        String[] line;
        while(true) {
            input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if(w==0 && h ==0)
                break;

            int[][]map = new int[h][w];
            visited = new boolean[h][w];
            for(int i = 0 ; i < h ; i++){
                line = br.readLine().split(" ");
                for(int j = 0 ; j < w; j++){
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            int cnt = 0;
            for(int i = 0 ; i < map.length ; i++){
                for(int j = 0 ; j < map[i].length ; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(map,new int[]{i,j});
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
