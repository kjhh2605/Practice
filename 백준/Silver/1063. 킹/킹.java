import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void move(char[] a, String s){
        if(s.equals("R")) {
            a[0]++;
        }else if(s.equals("L")){
            a[0]--;
        }else if(s.equals("B")){
            a[1]--;
        }else if(s.equals("T")){
            a[1]++;
        }else if(s.equals("RT")){
            a[0]++;
            a[1]++;
        }else if(s.equals("LT")){
            a[0]--;
            a[1]++;
        }else if(s.equals("RB")){
            a[0]++;
            a[1]--;
        }else if(s.equals("LB")){
            a[0]--;
            a[1]--;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        char[] king = new char[2];
        char[] stone = new char[2];
        char[] tmpK = new char[2];
        char[] tmpS = new char[2];
        for(int i = 0 ; i < 2 ; i ++){
            king[i] = line[0].charAt(i);
            stone[i] = line[1].charAt(i);
        }
        int n = Integer.parseInt(line[2]);
        while(n > 0){
            n--;
            String s = br.readLine();
            tmpK = king.clone();
            tmpS = stone.clone();
            move(king,s);
            if(king[0] == stone[0] && king[1] == stone[1])
                move(stone,s);
            if(king[0] > 'H' || king[0] < 'A' || king[1] < '1' || king[1] > '8'
            || stone[0] > 'H' || stone[0] < 'A' || stone[1] < '1' || stone[1] > '8'){
                king = tmpK.clone();
                stone = tmpS.clone();
            }

        }

        System.out.printf("%c%c\n",king[0],king[1]);
        System.out.printf("%c%c\n",stone[0],stone[1]);
    }
}
