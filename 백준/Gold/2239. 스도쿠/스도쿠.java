import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int [][] answer = new int[9][9];
    static boolean f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 9 ; i++){
            String[] line = br.readLine().split("");
            for(int j = 0 ; j < 9 ; j++){
                int v = Integer.parseInt(line[j]);
                if(v!=0){
                    answer[i][j] = v;
                }
            }
        }
        dfs(0);
        StringBuilder sb = new StringBuilder();
        for(int[] line : answer){
            for(int i : line){
                sb.append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(int depth){
        if(f) return;
        if(depth == 81){
            f = true;
            return;
        }
        int x = depth%9;
        int y = depth/9;
        if(answer[y][x] == 0){
            for(int i = 1  ; i <= 9 ; i++){
                if(check(i,x,y)){
                    answer[y][x] = i;
                    dfs(depth+1);
                    if(f) return;
                    answer[y][x] = 0;
                }
            }
        }else{
            dfs(depth+1);
        }

    }
    static boolean check(int v, int x, int y){
        boolean flag = true;
        for(int i=0 ; i<9 ; i++){
            if(answer[i][x] == v || answer[y][i] == v){
                flag = false;
                break;
            }
        }
        int boxY = (y / 3) * 3;
        int boxX = (x / 3) * 3;
        for (int i = boxY; i < boxY + 3; i++) {
            for (int j = boxX; j < boxX + 3; j++) {
                if (answer[i][j] == v) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}