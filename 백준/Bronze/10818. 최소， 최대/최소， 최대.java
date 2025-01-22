import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       int N = sc.nextInt();
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       for(int i = 0 ; i < N ; i++){
           int a = sc.nextInt();
           if(a>max)
               max=a;
           if(a<min)
               min=a;
       }
        System.out.println(min + " " + max);
    }
}
