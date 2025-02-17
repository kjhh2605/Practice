import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> s = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();
        for(int i=1 ; i <= 20 ; i++){
            a.add(String.valueOf(i));
        }
        while(n-- > 0){
            String[] line = br.readLine().split(" ");
            switch (line[0]){
                case"add":
                    if(!s.contains(line[1]))
                        s.add(line[1]);
                    break;
                case"remove":
                    if(s.contains(line[1]))
                        s.remove(line[1]);
                    break;
                case"check":
                    sb.append(s.contains(line[1])?"1":"0").append("\n");
                    break;
                case"toggle":
                    if (s.contains(line[1])) {
                        s.remove(line[1]);
                    } else {
                        s.add(line[1]);
                    }break;
                case"all":
                    s=new ArrayList<>(a);
                    break;
                case"empty":
                    s.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
