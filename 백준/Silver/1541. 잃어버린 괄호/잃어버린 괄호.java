import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int answer = 0;
        int tmp = 0;
        for(int i = 0 ; i < line.length() ; i++){
            char c = line.charAt(i);
            if(c != '+' && c != '-' ){
                sb.append(c);
                if(i != line.length()-1)
                    continue;
            }

            int a = Integer.parseInt(sb.toString());
            sb.setLength(0);
            if(!flag) { // 앞에 마이너스가 없으면
                answer += a;
            } else{ // 앞에 마이너스 있을 때
                tmp += a;
                if(c == '-'){
                    answer -= tmp;
                    tmp = 0;
                }
            }
            if(c == '-')
                flag = true;
        }
        if(tmp != 0 ){
            answer -= tmp;
        }
        System.out.println(answer);
    }
}
