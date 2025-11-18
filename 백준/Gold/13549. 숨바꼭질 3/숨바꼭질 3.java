import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int max = 200000;
        int[] minTime = new int[max + 1];
        Arrays.fill(minTime, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        minTime[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                System.out.println(minTime[k]);
                return;
            }

            if (cur * 2 <= max && minTime[cur * 2] == -1) {
                minTime[cur * 2] = minTime[cur];
                q.addFirst(cur * 2);
            }

            if (cur - 1 >= 0 && minTime[cur - 1] == -1) {
                minTime[cur - 1] = minTime[cur] + 1;
                q.addLast(cur - 1);
            }

            if (cur + 1 <= max && minTime[cur + 1] == -1) {
                minTime[cur + 1] = minTime[cur] + 1;
                q.addLast(cur + 1);
            }
        }
    }
}