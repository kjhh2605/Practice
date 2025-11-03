import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(n-->0){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while(pq.size()!=1){
            int a = pq.poll();
            int b = pq.poll();
            cnt+=a+b;
            pq.add(a+b);
        }
        System.out.println(cnt);
    }
}