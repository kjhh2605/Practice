import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int[] a = {Integer.parseInt(line[0]), Integer.parseInt(line[1])};
            list.add(a);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1])
                    rank[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : rank) {
            sb.append(r+1).append(" ");
        }
        System.out.println(sb);
    }
}
