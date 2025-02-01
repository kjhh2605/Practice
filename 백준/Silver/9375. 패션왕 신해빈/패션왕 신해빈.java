import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n > 0){
            n--;
            int m = Integer.parseInt(br.readLine());
            HashMap<String,Integer> h = new HashMap<>();
            for(int i = 0 ;  i < m ; i++) {
                String[] line = br.readLine().split(" ");
                String kind = line[1];
                if (!h.containsKey(kind)) {
                    h.put(kind, 1);
                } else {
                    h.replace(kind, h.get(kind) + 1);
                }
            }
            int cnt = 1;
            for (String s : h.keySet()) {
                cnt *= (h.get(s)+1);
            }
            sb.append(cnt-1).append("\n");
        }
        System.out.println(sb);
    }
}
