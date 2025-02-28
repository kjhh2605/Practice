import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> h = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int i = Integer.parseInt(br.readLine());
            if(i == 0){
                sb.append(h.isEmpty()?0:h.remove()).append("\n");
            }else{
                h.add(i);
            }
        }
        System.out.println(sb);
    }
}
