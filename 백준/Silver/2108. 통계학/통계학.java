import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> h = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            int i = Integer.parseInt(br.readLine());
            list.add(i);
            if (h.containsKey(i))
                h.replace(i, h.get(i) + 1);
            else
                h.put(i, 1);

            if(h.get(i) > cnt)
                cnt = h.get(i);
        }
        Set<Integer> keys = h.keySet();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        PriorityQueue<Integer> mode = new PriorityQueue<>();
        for (Integer key : keys) {
            int a = h.get(key);

            if(key > max)
                max = key;
            if(key < min)
                min = key;

            if(a == cnt)
                mode.add(key);

            sum += (key * a);
        }

        sb.append(Math.round((double) sum / n)).append("\n"); // 산술 평균

        list.sort(null);
        sb.append(list.get(list.size()/2)).append("\n"); // 중앙값

        if(mode.size() >= 2){
            mode.poll();
        }
        sb.append(mode.poll()).append("\n"); // 최빈값

        sb.append(max-min); // 범위

        System.out.println(sb);
    }
}
