import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] items = new int[n];
        for(int i = 0 ; i < n ; i++){
            items[i] = sc.nextInt();
        }

        Arrays.sort(items);

        int disMax = 0; // 확인을 시작할 최대 간격
        for(int i = 1 ; i < n ; i++){
            int d = items[i] - items[i-1];
            if(d > disMax)
                disMax = d;
        }

        boolean find = false;
        for(int i = disMax ; i > 0 ; i--){
            int cur = items[0];
            int cnt = 0;
            int check = 1;
            while(true){
                cur += i;
                cnt++;
                if(cur > items[check]) // 건너 뛰면 실패
                    break;
                if(cur == items[n-1]) {
                    find = true;
                    break;
                }
                if(cur == items[check])
                    check++;


            }
            if(find){
                System.out.println(cnt + 1 - n);
                return;
            }else{
                continue;
            }
        }
    }
}
