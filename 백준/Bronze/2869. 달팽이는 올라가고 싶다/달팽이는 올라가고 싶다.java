import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int day = sc.nextInt();
        int night = sc.nextInt();
        int dis = sc.nextInt();
        int dayMove = day - night;
        int tmpDis = dis - day;
        int answer = 1;
        double a = (double)tmpDis/(double)dayMove;
        if(a-(tmpDis/dayMove) > 0){
            answer ++;
        }
        answer += tmpDis/dayMove;
        System.out.println(answer);

    }
}
