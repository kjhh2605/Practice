import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> h = new HashSet<>();
        int cnt = 1;
        int round = 1;
        boolean flag = false;
        char cur = words[0].charAt(words[0].length()-1);
        h.add(words[0]);
        for(int i = 1 ; i < words.length ; i++){
            cnt++;
            if(cnt > n){
                cnt = 1;
                round++;
            }
            if(words[i].charAt(0)!=cur)
                break;
            if(h.contains(words[i]))
                break;
            else{
                h.add(words[i]);
                cur = words[i].charAt(words[i].length()-1);
            }
            if(i==words.length-1)
                flag = true;
        }
    
        return flag?new int[]{0,0}:new int[]{cnt,round};
    }
}