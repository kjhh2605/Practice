import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        for(char c = 'a' ; c <= 'z' ; c+=1 ){
            int answer = -1;
            for(int i = 0 ; i < s.length() ; i++){
                if(s.charAt(i) == c) {
                    answer = i;
                    break;
                }
            }
            System.out.print(answer + " ");
        }
    }
}
