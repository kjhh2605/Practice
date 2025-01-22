import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            int n = sc.nextInt();
            n%=42;
            if(!list.contains(n))
                list.add(n);
        }
        System.out.println(list.size());
    }
}
