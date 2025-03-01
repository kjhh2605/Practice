import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    private static ArrayList<int[]> answer;
    private static int[] a;
    public static void search(int depth, int n, int m){
        if(depth == m){
            int cur = 0;
            for(int i = 0 ; i < a.length-1 ; i++){
                cur = a[i];
                if(a[i+1] < cur)
                    return;
            }
            answer.add(a.clone());
            return;
        }
        for(int i = 1 ; i <= n ; i++){
            a[depth] = i;
            search(depth+1,n,m);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        answer = new ArrayList<>();
        a = new int[m];
        search(0,n,m);
        for (int[] ints : answer) {
            for(int i = 0 ; i < ints.length ; i++){
                sb.append(ints[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
