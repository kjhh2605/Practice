import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[]line = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(a);
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                sum += a[j];
            }
        }
        System.out.println(sum);
    }
}
