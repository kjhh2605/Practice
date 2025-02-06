import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Stack<Integer> a = new Stack<>(); // 현재
        Stack<Integer> b = new Stack<>(); // 보조
        for(int i = n-1 ; i > -1 ; i--){
            a.push(Integer.parseInt(line[i]));
        }

        boolean isPossible = true;
        int turn = 1;
        int[] pos = new int[1001]; // 0이면 a, 1이면 b
        while(isPossible){
            if(a.empty() && b.empty()) // 다 들어가면 종료
                break;
            // 맨 앞 사람 차례이면
            if(!a.empty() && a.peek() == turn){
                a.pop();
                turn++;
                continue;
            }else if(!b.empty() && b.peek() == turn){
                turn++;
                b.pop();
                continue;
            }

            if(pos[turn] == 0){ // a에 있으면
                while(a.peek() != turn){
                    pos[a.peek()] = -1;
                    b.push(a.pop()); // b로 옮김
                }
                continue;
            }

            if(pos[turn] == -1 && b.peek() != turn)
                isPossible = false;
        }

        if(isPossible)
            System.out.println("Nice");
        else
            System.out.println("Sad");

    }
}
