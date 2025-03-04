import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        int cnt = 1;
        while (a != b) {
            boolean check = false;
            if (b % 2 == 0) {
                b /= 2;
                check = true;
            } else if (b % 10 == 1) {
                long tmp = b % 10;
                b = (b - tmp) / 10;
                check = true;
            }

            if(a > b || !check){
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
