import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int k = sc.nextInt();  
        int n = sc.nextInt(); 
        int[] size = new int[k];

        for (int i = 0; i < k; i++) {
            size[i] = sc.nextInt();
        }

        Arrays.sort(size); 
        long left = 1; 
        long right = size[k - 1]; 
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += size[i] / mid;
            }

            if (cnt >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
