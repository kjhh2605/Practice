import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            g[i] = new ArrayList<>();
        }

        String[] line;
        while(n-- > 1){
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            g[a].add(b);
            g[b].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            ArrayList<Integer> a = g[cur];
            for (Integer i : a) {
                if(parent[i] == 0) {
                    parent[i] = cur;
                    q.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2 ; i < parent.length ; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }
}
