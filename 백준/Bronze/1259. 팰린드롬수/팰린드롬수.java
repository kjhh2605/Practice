import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String n = br.readLine();
            if(n.equals("0"))
                break;
            for(int i = n.length()-1 ; i > -1 ; i--){
                sb.append(n.charAt(i));
            }
            String tmp = sb.toString();
            if(tmp.equals(n))
                System.out.println("yes");
            else
                System.out.println("no");
            sb.setLength(0);
        }

    }
}
