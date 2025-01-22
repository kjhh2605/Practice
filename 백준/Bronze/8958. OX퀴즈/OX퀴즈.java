import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       int T = sc.nextInt();
       sc.nextLine();
       while(T>0){
          T--;
          String line = sc. nextLine();
          int combo = 0;
          int score = 0;
          String[]split = line.split("");
          for(int i = 0 ; i < split.length ; i++){
              if(split[i].equals("O")){
                  combo++;
                  score+=combo;
              }else{
                  combo = 0;
              }
          }
           System.out.println(score);
        }
    }
}
