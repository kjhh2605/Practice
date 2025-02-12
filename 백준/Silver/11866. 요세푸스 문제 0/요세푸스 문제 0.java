import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        StringBuilder sb = new StringBuilder("<");
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            a.add(i);
        }
        int cur = k-1;
        for(int i = 0; i < n && a.size() != 1; i++){
            while(cur > a.size()-1){
                cur -= a.size();
            }
            sb.append(a.get(cur)).append(", ");
            a.remove(cur);
            cur+=(k-1);
        }
        sb.append(a.get(0)).append(">");
        System.out.println(sb);
    }
}
