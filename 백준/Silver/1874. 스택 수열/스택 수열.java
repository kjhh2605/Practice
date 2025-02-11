import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        for(int i = 0 ; i < n ; i++){
            seq[i] = Integer.parseInt(br.readLine());
        }
        boolean flag = true;
        Stack<Integer> s = new Stack<>();
        int index = 0;
        int a = 1;
        while(flag){
            if(s.empty()) {
                if(a > n)
                    break;
                s.push(a);
                sb.append("+").append("\n");
                a++;
                continue;
            }
            if(s.peek() < seq[index]){
                s.push(a);
                sb.append("+").append("\n");
                a++;
                continue;
            }else if (s.peek() == seq[index]){
                s.pop();
                sb.append("-").append("\n");
                index++;
                continue;
            }else{
                flag = false;
            }
        }
        if(flag)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
