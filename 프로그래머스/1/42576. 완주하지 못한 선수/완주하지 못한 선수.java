import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : participant){
            if(map.containsKey(s))
                map.replace(s,map.get(s)+1);
            else
                map.put(s,1);
        }
        for(String s : completion){
            map.replace(s,map.get(s)-1);
        }
        HashSet<String>keys = new HashSet<>(Arrays.asList(participant));
        for(String key : keys){
            if(map.get(key)==1)
                return key;
        }
        return"";
    }
}