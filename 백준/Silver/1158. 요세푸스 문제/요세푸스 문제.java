
import java.io.IOException;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       String[] line = sc.nextLine().split(" ");
       int n = Integer.parseInt(line[0]);
       int k = Integer.parseInt(line[1]);
       ArrayList<Integer> a = new ArrayList<>();
       ArrayList<Integer> answer = new ArrayList<>();
       for(int i=1;i<=n;i++){
            a.add(i);
       }
       int cur = 0;
       while(!a.isEmpty()){
           cur = (cur + k -1) % a.size();
           answer.add(a.get(cur));
           a.remove(cur);
       }
        System.out.println(answer.toString().replace("[", "<").replace("]", ">"));
    }

}