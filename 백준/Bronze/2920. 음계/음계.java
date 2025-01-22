import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[]array = new int[8];
        for(int i = 0 ; i < 8 ; i++){
            array[i] = sc.nextInt();
        }

        if(array[0] == 1){
            boolean flag = true;
            for(int i = 0 ; i < 8 ; i++){
                if(!(array[i] == i+1)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("ascending");
                return;
            }
        }

        if(array[0] == 8){
            boolean flag = true;
            for(int i = 0 ; i < 8 ; i++){
                if(!(array[i] == 8-i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("descending");
                return;
            }
        }
        System.out.println("mixed");
    }
}
