import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int h = sc.nextInt();
        int m = sc.nextInt();
        int time = sc.nextInt();

        m += time;
        int M = m%60;
        int H = m/60;

        h += H;
        if(h > 23)
            h -= 24;
        m = M;

        System.out.println(h + " " + m);
    }
}
