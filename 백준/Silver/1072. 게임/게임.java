import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        long z = (long)y*100/x;
        int start = 0;
        int end = 1000000000;
        int answer = -1;
        while(start<=end){
            int n = start+(end-start)/2;
            long tmp = (long)(y+n)*100/(x+n);
            if(tmp > z){
                end = n-1;
                answer = n;
            }else if(tmp <= z){
                start = n+1;
            }
        }

        System.out.println(answer);
    }
}
