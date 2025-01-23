import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] array = new int[N];
        int[] tmp = new int[N];
        int[] answer = new int[N];
        StringBuilder as = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            tmp[i] = array[i];
        }

        Arrays.sort(tmp);

        int cur = tmp[0];
        list.add(tmp[0]);
        for (int i : tmp) {
            if (i != cur) {
                list.add(i);
                cur = i;
            }
        }

        HashMap<Integer, Integer> h = new HashMap<>();
        int result = 0; // 정렬된 list -> 인덱스 == 앞에 있는 좌표 수
        for (Integer i : list) {
            h.put(i,result);
            result++;
        }
        for (int i = 0; i < N; i++) {
            answer[i] = h.get(array[i]);
            as.append(h.get(array[i])).append(" ");
        }
//        for (int i : answer) {
//            System.out.print(i + " ");
//        }
        System.out.println(as);
    }
}
