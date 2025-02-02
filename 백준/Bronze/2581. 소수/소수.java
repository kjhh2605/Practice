import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        boolean find = false;
        int[]isPrime = new int[n+1];
        isPrime[1] = -1;
        for(int i = 2 ; i*i <= n ; i++){
            if(isPrime[i] == 0){
                for(int j = i*i ; j <= n ; j += i ){
                    isPrime[j] = -1;
                }
            }
        }
        for(int i = m ; i <= n ; i++){
            if(isPrime[i] == 0) {
                if(!find){
                    min = i;
                    find = true;
                }
                sum += i;
            }
        }
        if(find){
            System.out.println(sum);
            System.out.println(min);
        }else
            System.out.println(-1);

    }
}
