import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        sc.nextLine();
        while(T>0){
            T--;
            int n = sc.nextInt();
            String s = sc.next();
            String[]tmp = s.split("");
            for(int i = 0 ; i < tmp.length ; i++){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(tmp[i]);
                }
            }
            System.out.println();
        }
    }
}
