import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        for(int i =0  ; i < n ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][]dpMax = new int[n][3];
        int[][]dpMin = new int[n][3];
        dpMax[0] = map[0];
        dpMin[0] = map[0];
        for(int i = 1 ; i < n ; i++){
            int b = i-1;
            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + map[i][0];
            dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]) + map[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + map[i][2];
            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + map[i][0];
            dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]) + map[i][1];
            dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + map[i][2];

        }
        int max = Math.max(Math.max(dpMax[n-1][0],dpMax[n-1][1]),dpMax[n-1][2]);
        int min = Math.min(Math.min(dpMin[n-1][0],dpMin[n-1][1]),dpMin[n-1][2]);
        System.out.println(max+" "+min);
    }
}