import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer>list = new HashMap<>();
        for(int i = 0 ; i < want.length ; i++){
            list.put(want[i],number[i]);
        }
        for(int i = 0 ; i < discount.length-9 ; i++){
            String item = discount[i];
            if(!list.containsKey(item))
                continue;
            HashMap<String,Integer> clone = (HashMap<String, Integer>) list.clone();
            for(int j = i ; j < i+10 ; j++){
                String t = discount[j];
                if(!list.containsKey(t))
                    break;
                if(clone.get(t)-1 < 0)
                    break;
                clone.replace(t,clone.get(t)-1);
                if(j==i+9)
                    answer++;
            }
        }
        return answer;
    }
}