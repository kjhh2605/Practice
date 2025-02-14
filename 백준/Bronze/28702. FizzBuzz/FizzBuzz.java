import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        for(int i = 0 ; i < 3 ; i++){
            String s = br.readLine();
            if(s.charAt(0) >= '1' && s.charAt(0) <= '9') {
                t = Integer.parseInt(s) + 3 - i;
            }
        }

        String a = String.valueOf(t);
        int c = 0;
        for(int i = 0 ; i < a.length() ; i++){
            c += Character.getNumericValue(a.charAt(i));
        }

        if(c % 3 == 0 && t % 5 == 0) {
            System.out.println("FizzBuzz");
        }else if(t % 5 == 0){
            System.out.println("Buzz");
        }else if(c % 3 == 0){
            System.out.println("Fizz");
        }else
            System.out.println(t);

    }
}
