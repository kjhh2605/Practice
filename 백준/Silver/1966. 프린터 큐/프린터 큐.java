import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);
            String[] line = br.readLine().split(" ");
            ArrayDeque<Integer[]>q = new ArrayDeque<>();
            int[] priority = new int[10];
            for(int i = 0 ; i < N ; i++){
                int p = Integer.parseInt(line[i]);
                Integer[] ip = new Integer[2];
                ip[0] = i; // 문서 초기 위치
                ip[1] = p; // 우선 순위
                q.addLast(ip);
                priority[p]++;
            }
            int cnt = 0;
            boolean flag = true;
            for(int i = 9 ; i > 0 && flag  ; i--){
                while(priority[i]-- > 0){
                    while(true){
                        if(q.peekFirst()[1] != i)
                            q.addLast(q.poll()); // 앞에서 뽑아서 뒤에 삽입
                        if(q.peekFirst()[1] == i)
                            break;
                    }
                    if(q.poll()[0] == M){
                        cnt++;
                        flag = false;
                        break;
                    }else{
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

}
