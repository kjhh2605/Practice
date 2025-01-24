import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String,String>h = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String s = sc.nextLine();
            String name = s.split(" ")[0];
            String status = s.split(" ")[1];
            if(h.containsKey(name))
                h.replace(name,status);
            else
                h.put(name,status);
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String s : h.keySet()) {
            if(h.get(s).equals("enter"))
                answer.add(s);
        }
        answer.sort(Comparator.reverseOrder());
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
