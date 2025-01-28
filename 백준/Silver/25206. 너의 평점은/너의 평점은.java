import java.io.*;
import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0; // 전체 점수
        double num = 0; // 학점
        for(int i = 0 ; i < 20 ; i++){
            String[] line = br.readLine().split(" ");
            if(line[2].equals("P")) {
                continue;
            }
            double n = Double.parseDouble(line[1]); // 학점
            num += n;
            if(line[2].equals("A+"))
                sum += n*(4.5);
            else if(line[2].equals("A0"))
                sum += n*(4.0);
            else if(line[2].equals("A0"))
                sum += n*(4.0);
            else if(line[2].equals("B+"))
                sum += n*(3.5);
            else if(line[2].equals("B0"))
                sum += n*(3.0);
            else if(line[2].equals("C+"))
                sum += n*(2.5);
            else if(line[2].equals("C0"))
                sum += n*(2.0);
            else if(line[2].equals("D+"))
                sum += n*(1.5);
            else if(line[2].equals("D0"))
                sum += n*(1.0);
            else if(line[2].equals("F0"))
                sum += n*(0.0);
        }
        System.out.println(sum/num);





    }
}
