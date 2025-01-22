import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        for(int i = 0 ; i < a ; i++){
            for(int j = 0 ; j < i+1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
