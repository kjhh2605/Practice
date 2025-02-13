import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        while(true){
            String line = br. readLine();
            if(line.charAt(0) == '.' && line.length() == 1)
                break;
            s.clear();
            for(int i = 0 ; i < line.length()-1 ; i++){
                char c = line.charAt(i);
                if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || c == ' ' )
                    continue;
                if(!s.empty() && s.peek() == '(' && c == ')') {
                    s.pop();
                }else if(!s.empty() && s.peek() == '[' && c == ']'){
                    s.pop();
                }else{
                    s.push(c);
                }
            }
            if(s.empty())
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
