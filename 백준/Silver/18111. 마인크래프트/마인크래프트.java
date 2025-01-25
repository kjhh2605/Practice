import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int y = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);
        int item = Integer.parseInt(firstLine[2]);

        int high = 0;
        int low = 500;

        // 2차원 배열의 입력을 1차원 배열로 변환하여 저장
        int[] ground = new int[x * y];
        for (int i = 0; i < y; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                int input = Integer.parseInt(row[j]);
                ground[i * x + j] = input;
                if (input > high) high = input;
                if (input < low) low = input;
            }
        }

        int time = 0;
        while (high - low > 0) {
            int lowCnt = 0;
            int highCnt = 0;
            for (int i : ground) {
                if(i == low)
                    lowCnt++;
                if(i == high)
                    highCnt++;
            }
            if(lowCnt > item){ // low 다 채울 수 없으면 삭제
                for (int i = 0 ; i < ground.length ; i++ ){
                    if(ground[i] == high) {
                        ground[i]--;
                        item++;
                        time += 2;
                    }
                }
                high--;
            }
            else if(lowCnt > highCnt*2 ){ // 삭제하는 경우
                for (int i = 0 ; i < ground.length ; i++ ){
                    if(ground[i] == high) {
                        ground[i]--;
                        item++;
                        time += 2;
                    }
                }
                high--;
            }else{
                for (int i = 0 ; i < ground.length ; i++ ){
                    if(ground[i] == low) {
                        ground[i]++;
                        item--;
                        time += 1;
                    }
                }
                low++;
            }
        }
        System.out.println(time + " " + high);

    }

}
