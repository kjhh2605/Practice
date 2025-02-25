import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" " );
        int[] t = new int[n];
        for(int i = 0 ; i < n ; i++){
            t[i] = Integer.parseInt(line[i]);
        }
        int start = 0;
        int nextStart = 0;
        int answer = 0;
        int a = t[start];
        int b = 0;
        int end = 0;
        for(end = 1 ; end < n ; end++){
           if(t[end] != a && b == 0){
               b = t[end];
               nextStart = end;
               continue;
           }
           if(t[end] != a && t[end] != b){
               if(end - start > answer)
                   answer = end - start;
               int tmp = end-1;
               int x = t[tmp];
               while(tmp-- > start){
                   if(t[tmp] != x) {
                       break;
                   }
               }
               start = tmp+1;
               a = t[start];
               b = t[end];
           }
        }
        if(end - start > answer){
            answer = end - start;
        }
        System.out.println(b!=0?answer:n);
    }
}
