import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> h = new HashMap<>();
        ArrayList<String[]> a = new ArrayList<>();
        
        for(String string : record){
            String[] s = string.split(" ");            
            if(!s[0].equals("Change")){
                if(s[0].equals("Enter")){
                    a.add(new String[]{s[1],"님이 들어왔습니다."});
                    if(h.containsKey(s[1]))
                        h.replace(s[1],s[2]);
                    else
                        h.put(s[1],s[2]);
                }
                else
                    a.add(new String[]{s[1],"님이 나갔습니다."});
            }else{
                h.replace(s[1],s[2]);
            } 
        }
        
        String[] answer = new String[a.size()];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < a.size() ; i++){
            sb.append(h.get(a.get(i)[0])).append(a.get(i)[1]);
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}