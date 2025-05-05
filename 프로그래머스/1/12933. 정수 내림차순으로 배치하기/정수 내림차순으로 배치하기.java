import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            a.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        a.sort(Collections.reverseOrder());
        for(int i = 0 ; i < a.size() ; i++){
            answer *= 10;
            answer+=a.get(i);
        }
        return answer;
    }
}