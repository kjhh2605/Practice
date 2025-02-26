import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[][] map = new String[n][m];
        ArrayDeque<Point> search = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split("");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = s[j];
                if(s[j].equals("I")){
                   search.add(new Point(i,j));
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int cnt = 0;
        while(!search.isEmpty()){
            Point cur = search.poll();
            for(int i = 0 ; i < 4 ; i++){
                if(cur.x + dx[i] == n || cur.x + dx[i] < 0)
                    continue;
                if(cur.y + dy[i] == m || cur.y + dy[i] < 0 )
                    continue;
                if(visited[cur.x + dx[i]][cur.y + dy[i]])
                    continue;
                if(map[cur.x + dx[i]][cur.y + dy[i]].equals("O")){
                    search.add(new Point(cur.x + dx[i],cur.y + dy[i]));
                    visited[cur.x + dx[i]][cur.y + dy[i]] = true;
                }else if(map[cur.x + dx[i]][cur.y + dy[i]].equals("P")){
                    search.add(new Point(cur.x + dx[i],cur.y + dy[i]));
                    visited[cur.x + dx[i]][cur.y + dy[i]] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt!=0?cnt:"TT");

    }
}
