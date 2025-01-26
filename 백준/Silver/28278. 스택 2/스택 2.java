import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> s = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (Integer.parseInt(input[0])) {
                case 1:
                    int x = Integer.parseInt(input[1]);
                    s.push(x);
                    break;
                case 2:
                    if (!s.isEmpty())
                        sb.append(s.pop()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;
                case 3:
                    sb.append(s.size()).append("\n");
                    break;
                case 4:
                    sb.append(s.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 5:
                    if (!s.isEmpty())
                        sb.append(s.peek()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
