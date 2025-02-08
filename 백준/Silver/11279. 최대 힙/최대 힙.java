import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim()); 
        PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String input = br.readLine(); 
            if (input == null) continue; 
            int a = Integer.parseInt(input.trim()); 
            if (a == 0) {
                if (!h.isEmpty()) {
                    sb.append(h.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                h.add(a);
            }
        }
        System.out.print(sb);
    }
}
