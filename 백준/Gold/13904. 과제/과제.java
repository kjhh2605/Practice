import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        //점수 내림차순
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        int maxDay = 0;
        for(int i = 0 ; i < n ; i++){
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            if(tmp[0] > maxDay){
                maxDay = tmp[0];
            }
            q.add(tmp);
        }
        int[] task = new int[maxDay+1];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int day = cur[0];
            int score = cur[1];
            for(int i = day ; i > 0 ; i--){
                if(score > task[i]){
                    task[i] = score;
                    break;
                }
            }
        }
        int answer = 0;
        for(int i = 1 ; i < task.length ; i++){
            answer += task[i];
        }
        System.out.println(answer);
    }
}