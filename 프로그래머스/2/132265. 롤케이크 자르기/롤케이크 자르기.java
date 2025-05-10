import java.util.*;
class Solution {
    public int solution(int[] topping) {
        // 조각수 2, 토핑 종류 수 같게 -> 방법 수
        int answer = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int t : topping){
            h.put(t,h.getOrDefault(t,0)+1);
        }
        int all = h.size();
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>(h.keySet());
        for(int i = 0 ; i < topping.length ; i++){
            int t = topping[i];
            a.add(t); 
            h.put(t,h.get(t)-1);
            if(h.get(t)==0){
                b.remove(t);
            }
            if(a.size()==b.size()){
                answer++;
            }
            
        }
        return answer;
    }
}