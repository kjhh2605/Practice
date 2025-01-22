import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a<b){
            System.out.println("<");
        }
        if(a == b)
            System.out.println("==");
        if(a>b)
            System.out.println(">");
    }
}
