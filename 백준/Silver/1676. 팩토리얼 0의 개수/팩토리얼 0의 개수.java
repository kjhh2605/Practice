import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = n ; i > 0 ; i--){
            if(i%5 == 0){
                int tmp = i;
                while(tmp%5 == 0){
                    tmp/=5;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
