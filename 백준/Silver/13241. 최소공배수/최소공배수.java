import java.io.*;

public class Main {
    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        long gcd = gcd(a,b);
        System.out.println((a/gcd)*(b/gcd)*gcd);
    }
}
