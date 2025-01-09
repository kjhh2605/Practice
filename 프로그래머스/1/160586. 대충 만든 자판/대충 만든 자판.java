import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character,Integer> h = new HashMap();
        
        for(String s : keymap){
           for(int i = 0 ; i < s.length() ; i++){
               char c = s.charAt(i);
               if(!h.containsKey(c)){ // 기존에 없던 문자면
                   h.put(c,i+1);
               }
               else
               {
                   if(h.get(c) > i+1) // 더 빨리 입력 가능하면
                       h.replace(c,i+1); // 수정
               }
     
           }
       }
        
        for(int i = 0 ; i < targets.length ; i++){
            int cnt = 0;
            for(int j = 0 ; j < targets[i].length() ; j++){
                char c = targets[i].charAt(j);
                if(!h.containsKey(c)){ // 입력 불가능
                    cnt = -1; 
                    break; 
                }
                cnt += h.get(c);
            }   
            answer[i] = cnt;
        }
        
        return answer;
    }
}