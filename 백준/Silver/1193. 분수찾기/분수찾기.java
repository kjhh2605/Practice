import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int line = 1;
        int cnt = 0;
        int n = sc.nextInt();
        while(n>0){
            n--;
            cnt++;
            if(n==0 && line == cnt)
                break;
            if(line == cnt ){
                line ++;
                cnt = 0;
            }
        }
        int a,b;
        if(line%2 == 0){
            a = cnt; //분자
            b = line - cnt + 1;
        }else{
            a = line - cnt + 1;
            b = cnt;
        }
        System.out.println(a+"/"+b);
    }
}
