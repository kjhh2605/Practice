import java.util.*;

class Solution {
    public int[] solution(String s) {
        String st = s.substring(2, s.length() - 2);
        String[] tmp = st.split("\\},\\{");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            list.add(tmp[i]);
        }

        list.sort((a,b)->Integer.compare(a.length(),b.length()));

        HashSet<String> h = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (String t : list) {
            String[] tt = t.split(",");
            for (int i = 0; i < tt.length; i++) {
                if (!h.contains(tt[i])) {
                    h.add(tt[i]);
                    answer.add(Integer.parseInt(tt[i]));
                    break;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
