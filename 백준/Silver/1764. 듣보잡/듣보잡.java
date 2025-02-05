import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        HashSet<String> a = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            a.add(s);
        }
        ArrayList<String> b = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < m ; i++){
            String s = br.readLine();
            if(a.contains(s)) {
                b.add(s);
                cnt++;
            }
        }
        Collections.sort(b);
        StringBuilder sb = new StringBuilder();
        for (String s : b) {
            sb.append(s).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
