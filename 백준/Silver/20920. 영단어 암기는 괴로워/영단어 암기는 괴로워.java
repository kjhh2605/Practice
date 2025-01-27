import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        HashMap<String,Integer> freq = new HashMap<>(); // 단어,등장횟수
        int freqMax = 1;
        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            if(s.length() < m) // 짧은 단어 제외
                continue;

            if(freq.containsKey(s)) {
                freq.replace(s, freq.get(s) + 1);
                if(freq.get(s) > freqMax)
                    freqMax = freq.get(s);
            }
            else
                freq.put(s,1);
        }

        ArrayList<String>[] list = new ArrayList[freqMax+1]; // index는 등장 빈도
        for (String s : freq.keySet()) {
            if(list[freq.get(s)] == null)
                list[freq.get(s)] = new ArrayList<>();
            list[freq.get(s)].add(s); // 등장 빈도를 기준으로 단어 분리
        }
        for(int i = freqMax ; i > -1 ; i--){
            if(list[i] == null)
                continue;
            ArrayList<String>[]ln = new ArrayList[11]; // index는 단어길이, 최대 10
            for(String s : list[i]){
                if(ln[s.length()] == null)
                    ln[s.length()] = new ArrayList<>();
                ln[s.length()].add(s); // 길이 별로 분리
            }
            for(int j = 10 ; j > -1 ; j--){
                if(ln[j] == null)
                    continue;
                ln[j].sort(null); // 사전 순
                for(String s : ln[j]){
                    sb.append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
