import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        int[] card = new int[s2.length];
        for(int i = 0 ; i < card.length ; i++){
            card[i] = Integer.parseInt(s2[i]);
        }
        int v = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 0 ; i < card.length ; i++){
            for(int j = 0 ; j < card.length && j!= i ; j++){
                for(int k = 0; k < card.length && k!=j ; k++){
                    if(m-(card[i]+card[j]+card[k]) >= 0 && m-(card[i]+card[j]+card[k]) < v) {
                        v = m - (card[i] + card[j] + card[k]);
                        answer = card[i]+card[j]+card[k];
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
