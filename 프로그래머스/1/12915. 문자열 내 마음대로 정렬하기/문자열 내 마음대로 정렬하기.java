import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String>[] a = new ArrayList[26];
        for(int i = 0 ; i < a.length ; i++){
            a[i] = new ArrayList<>();
        }
        for(String s : strings){
            char c = s.charAt(n);
            a[c-'a'].add(s);
        }
        for(int i = 0 ; i < a.length ; i++){
            a[i].sort(null);
            answer.addAll(a[i]);
        }

        return answer.toArray(new String[0]);
    }
}