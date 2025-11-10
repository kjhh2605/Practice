import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int all = (int)Math.pow(n,2);

        long left = 1;
        long right = (long)n*n;
        long mid = -1;

        long ans = -1;
        while(left<=right){
            mid = (left+right)/2;

            long cnt = 0;
            for(int i = 1; i <=n  ; i++){
                cnt += Math.min(mid/i,n);
            }
            
            if(cnt<k){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
        System.out.println(ans);

    }
}