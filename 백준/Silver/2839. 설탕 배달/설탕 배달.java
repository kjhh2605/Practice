import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        // 3,5 로 안나눠질 때
        // 5또는 3으로 빼다가 반대의 배수가 나오면 가능
        // 안되면 불가능
        ArrayList<Integer> answers = new ArrayList<>();
        
        int test5 = n;
        int cnt5 = 0;
        int test3 = n;
        int cnt3 = 0;
        while (test5 > 5) {
            test5 -= 5;
            cnt5++;
            if (test5 % 3 == 0) {
                answers.add((cnt5 + test5 / 3));
            }
        }
        while (test3 > 3) {
            test3 -= 3;
            cnt3++;
            if (test3 % 5 == 0) {
                answers.add((cnt3 + test3 / 5));
            }
        }

        if (n % 5 == 0) {
            answers.add(n / 5);
        }
        if (n % 3 == 0) {
            answers.add(n / 3);
        }
        if (answers.isEmpty()) {
            System.out.println(-1);
            return;
        }
        int answer = answers.get(0);
        for (int i = 0; i < answers.size(); i++) {
            if (answer > answers.get(i))
                answer = answers.get(i);
        }
        System.out.println(answer);
    }

}
