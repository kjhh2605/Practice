import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 네트워크 수
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++ ){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            g[a].add(b);
            g[b].add(a);
        }

        if(g[1].size() == 0){
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (Integer i : g[1]) {
            q.add(i);
        }
        int[]target = new int[n+1];
        while(q.size() > 0){
            int t = q.poll();
            for(Integer i : g[t]){
                if(!q.contains(i) && target[i]!=-1)
                    q.add(i);
                target[i] = -1;
            }
        }
        int cnt = -1; // 1번 제외
        for (int i : target) {
            if(i == -1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
