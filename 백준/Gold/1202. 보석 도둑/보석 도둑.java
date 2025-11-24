import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];
        long ans = 0;

        ArrayList<int[]> gem = new ArrayList<>(); //[무게,가격]
        while(n-->0){
            int[] g = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            gem.add(g);
        }

        ArrayList<Integer> backpack = new ArrayList<>();
        while(k-->0){
            backpack.add(Integer.parseInt(br.readLine()));
        }

        gem.sort(Comparator.comparingInt(a -> a[0]));
        backpack.sort(null);
        //가장 작은 가방에 그 가방에 들어갈 수 있는 것 중 가장 비싼거

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int gemIndex = 0;
        for(int b : backpack){
            for(int i = gemIndex; i < gem.size() && (gem.get(i)[0] <= b); i++){
                pq.add(gem.get(i)[1]);
                gemIndex++;
            }
            if(!pq.isEmpty()) 
                ans += pq.poll();
        }
        System.out.println(ans);
    }
}