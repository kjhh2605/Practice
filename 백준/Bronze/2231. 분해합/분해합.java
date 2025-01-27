import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean find = false;
        int n = 0;
        while(n < N){
            n++;
            int tmp = n;
            int sum = 0;
            while(tmp > 0){
                sum += tmp%10;
                tmp /= 10;
            }
            if((sum+n) == N) {
                find = true;
                break;
            }
        }
        if(find)
            System.out.println(n);
        else
            System.out.println(0);
    }
}
