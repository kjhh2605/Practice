import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int sqCnt = 1;
        for(int i = 1 ; i <= n ; i++){
            if(i == sqCnt*sqCnt){
                sqCnt++;
                dp[i] = 1;
                continue;
            }else {
                dp[i] = 4;
            }
            for(int j = 1 ; j*j <= i ; j++){
                int cnt = dp[i-j*j] + 1;
                if(cnt < dp[i])
                    dp[i] = cnt;
            }
        }
        System.out.println(dp[n]);
    }
}
