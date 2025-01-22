import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       String line = sc.nextLine();
       String[] words = line.split(" ");
       int cnt = 0;
        for (String word : words) {
            if(word.equals(""))
                cnt++;
        }
       System.out.println((words.length-cnt));
    }
}
