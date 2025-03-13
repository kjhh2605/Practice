import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {
    static class myComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b){
            int A = Math.abs(a);
            int B = Math.abs(b);
            if (A == B) {
                return a-b;
            }
            return A-B;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(new myComparator());
        while(n-- > 0){
            int i = Integer.parseInt(br.readLine());
            if(i==0){
                if(!q.isEmpty()){
                    sb.append(q.poll()).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                q.add(i);
            }
        }
        System.out.println(sb);
    }
}
