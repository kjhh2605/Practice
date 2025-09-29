import java.util.*;
import java.io.*;

public class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            
            int[] coins = new int[n];
            for(int i = 0 ; i < n ; i++){
                coins[i] = Integer.parseInt(br.readLine());
            }
            
            int[] dp = new int[k+1];
            dp[0] = 1;
            for(int i = 0 ; i < n ; i++){
                int c = coins[i];
                for(int j = c ; j <= k ; j++){
                    dp[j] += dp[j-c];
                }
            }
            
            System.out.println(dp[k]);
        }
}