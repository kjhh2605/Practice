import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        bfs.add(n);
        boolean[] visitied = new boolean[200001];
        visitied[n] = true;
        int time = -1;

        loop:
        while(true){
            time++;
            int s = bfs.size();
            for(int i = 0 ; i < s ; i++){
                int cur = bfs.poll();
                if(cur == m) {
                    break loop;
                }
                if(cur > m){ // 도착 위치 넘어갔으면
                    if(!visitied[cur-1]){
                        visitied[cur-1] = true;
                        bfs.add(cur-1);
                    }
                    continue;
                }else{
                    if(cur-1 > 0 && !visitied[cur-1]){
                        visitied[cur-1] = true;
                        bfs.add(cur-1);
                    }
                    if(!visitied[cur+1]){
                        visitied[cur+1] = true;
                        bfs.add(cur+1);
                    }if(cur*2 < 200000 && !visitied[cur*2]){
                        visitied[cur*2] = true;
                        bfs.add(cur*2);
                    }

                }
            }
        }
        System.out.println(time);
    }
}
