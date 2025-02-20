import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        ArrayList<Integer> a = new ArrayList<>();
        while(n-- > 0){
            a.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        for(int i = a.size()-1 ; i > -1 && k != 0 ; i--){
            int coin = a.get(i);
            while (coin <= k){
                cnt++;
                k -= coin;
            }
        }
        System.out.println(cnt);
    }
}
