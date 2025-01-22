import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            String s = sc.nextLine();
            String[] tmp = s.split(" ");
            int[]lines = new int[3];
            for(int i = 0 ; i < 3 ; i ++){
                lines[i] = Integer.parseInt(tmp[i]);
            }
            Arrays.sort(lines);
            if(lines[0] == 0 && lines[2] == 0)
                break;
            if(lines[2] >= lines[0]+lines[1]){
                System.out.println("Invalid");
                continue;
            }
            if(lines[0] == lines[2]){
                System.out.println("Equilateral");
                continue;
            }
            if(lines[0]!=lines[1] && lines[1]!=lines[2]){
                System.out.println("Scalene");
                continue;
            }
            System.out.println("Isosceles");
        }

    }
}
