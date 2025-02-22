import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winner = 0;
        int score = 0;
        for(int i = 0 ; i < 5 ; i++){
            String[] line = br.readLine().split(" ");
            int sc = 0;
            for (String s : line) {
                sc += Integer.parseInt(s);
            }
            if(sc > score) {
                score = sc;
                winner = i+1;
            }
        }
        System.out.println(winner + " " + score);
    }
}
