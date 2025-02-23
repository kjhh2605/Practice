import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static boolean check(Integer[][] paper){
        int s = paper[0][0];
        for (Integer[] line : paper) {
            for (int i : line) {
                if(i != s)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[][] paper = new Integer[n][n];
        ArrayList<Integer[][]> a = new ArrayList<>();
        for(int i = 0 ; i < paper.length ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < paper[i].length ; j++){
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }
        a.add(paper);
        int blue = 0;
        int white = 0;
        while(!a.isEmpty()){
            Integer[][] p = a.get(0);
            a.remove(0);
            if(!check(p)){
                int t = p.length / 2;
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        Integer[][] tmp = new Integer[t][t];
                        for (int i = 0; i < t; i++) {
                            for (int j = 0; j < t; j++) {
                                tmp[i][j] = p[i + x*t ][j + y*t];
                            }
                        }
                        a.add(tmp);
                    }
                }
            }else{
                if(p[0][0].equals(1))
                    blue++;
                else
                    white++;
            }
        }
        System.out.println(white+"\n"+blue);
    }
}
