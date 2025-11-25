import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int maxN = 1 << 15;
        boolean[] isSquare = new boolean[maxN + 1];

        // 제곱수 미리 계산하여 마킹 (Pre-computation)
        for (int i = 1; i * i <= maxN; i++) {
            isSquare[i * i] = true;
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)break;

            int cnt = 0;

            for(int i = 1; i*i <= n ; i++){
                int a = i*i;
                if(a == n){
                    cnt++;
                    continue;
                }

                for(int j = i ; j*j <= n ; j++){
                    int b = j*j;
                    if(a+b == n){
                        cnt++;
                        continue;
                    }

                    for(int k = j ; k*k <=n ; k++){
                        int c = k*k;
                        if(a+b+c == n){
                            cnt++;
                            continue;
                        }

                        int d = n-a-b-c;
                        if(d >= c && isSquare[d]){
                            cnt++;
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}