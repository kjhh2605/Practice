import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // n개의 자연수 m번의 질문
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            arr[i] = a[i-1];
        }
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            dp[i][i] = 1;
        }

        for(int i=1; i<=n-1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 1;
            }
        }

        for(int l = 3 ; l <= n ; l++){
            for(int i = 1 ; i+l-1 <= n ; i++){
                int s = i;
                int e = i+l-1;
                if(arr[s]==arr[e] && dp[s+1][e-1] == 1){
                    dp[s][e] = 1;
                }
            }
        }


        int m = Integer.parseInt(br.readLine());
        while( m-- > 0){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = input[0];
            int e = input[1];
            sb.append(dp[s][e] + "\n");
        }
        System.out.println(sb);
    }
}