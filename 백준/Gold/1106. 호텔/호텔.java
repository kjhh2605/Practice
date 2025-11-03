import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int C = input[0];
        int n = input[1];

        int[][] cost = new int[n][3];
        for(int i=0;i<n;i++){
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = Integer.MAX_VALUE;
        int[]dp = new int[C+100];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0;i<n;i++){
            int c = cost[i][0];
            int p = cost[i][1];
            for(int j = p ; j < dp.length ; j++){
                if(dp[j-p] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-p]+c);
                }
            }
        }

        for (int i = C; i < dp.length; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);

    }
}