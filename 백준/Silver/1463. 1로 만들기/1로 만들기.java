import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        if(n==2 || n==3){
            System.out.println(1);
            return;
        }
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        int i = 4;
        while(i <= n){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            int d = dp[i-1]+1;
            if(i%2==0) {
                a = dp[i/2] + 1;
            }
            if(i%3==0) {
                b = dp[i/3] + 1;
            }
            if((i-1)%2==0 || (i-1)%3==0){
                int x = Integer.MAX_VALUE;
                int y = Integer.MAX_VALUE;
                if((i-1)%2==0){
                    x=dp[(i-1)/2]+2;
                }
                if((i-1)%3==0){
                    y=dp[(i-1)/3]+2;
                }
                c=Math.min(x,y);
            }
            dp[i]=Math.min(Math.min(a,b),Math.min(c,d));
            i++;
        }
        System.out.println(dp[n]);
    }
}
