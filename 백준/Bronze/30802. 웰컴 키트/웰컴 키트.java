import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] size = new int[6];
        String[] line = br.readLine().split(" ");
        for(int i = 0 ; i < 6 ; i++){
            size[i] = Integer.parseInt(line[i]);
        }
        String[] line2 = br.readLine().split(" ");
        int T = Integer.parseInt(line2[0]);
        int P = Integer.parseInt(line2[1]);

        int t = 0;
        for (int i : size) {
            int a = i;
            a /= T;
            if(a*T < i)
                t += a+1;
            else
                t += a;
        }
        System.out.println(t);
        System.out.println(n/P + " " + n%P);

    }
}
