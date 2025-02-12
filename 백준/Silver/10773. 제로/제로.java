import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        while(n-- > 0){
            int i = Integer.parseInt(br.readLine());
           if(i == 0){
               s.pop();
           }else{
               s.push(i);
           }
        }
        int answer = 0;
        for (Integer i : s) {
            answer += i;
        }
        System.out.println(answer);
    }
}
