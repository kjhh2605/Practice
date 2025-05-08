import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> a = new ArrayList<>();
        for(int i : numbers){
            a.add(String.valueOf(i));
        }
        a.sort((x,b)->(b+x).compareTo(x+b));
        if(a.get(0).charAt(0) == '0')
            return String.valueOf(0);
        StringBuilder sb = new StringBuilder();
        for(String s : a){
            sb.append(s);
        }
        return sb.toString();
    }
}