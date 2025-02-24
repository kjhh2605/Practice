import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        while(n-- > 0){
            int t = Integer.parseInt(br.readLine());
            if(t > 3){
                for(int i = 4 ; i <= t ; i++){
                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                }
                sb.append(dp[t]).append("\n");
            }else{
                sb.append(dp[t]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
