import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        ArrayList<Integer>[] g = new ArrayList[n+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            g[i+1] = new ArrayList<>();
            q.add(i+1);
        }
        for(int i = 0; i < m ;i++){
            String[] l = br.readLine().split(" ");
            int a = Integer.parseInt(l[0]);
            int b = Integer.parseInt(l[1]);
            g[a].add(b);
            g[b].add(a);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur])
                continue;

            visited[cur] = true;
            ArrayDeque<Integer> search = new ArrayDeque<>();
            search.add(cur);
            while(!search.isEmpty()){
                int a = search.poll();
                for(int b : g[a]){
                    if(!visited[b]){
                        visited[b] = true;
                        search.add(b);
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
