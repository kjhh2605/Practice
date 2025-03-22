import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack();
        char first = sb.charAt(0);
        int cnt = 0;
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i = 0 ; i < s.length() ; i++){
            stack.clear();
            boolean check = false;
            for(int j = 0 ; j < s.length() ; j++){
                char c = sb.charAt(j);
                if(c == '(' || c == '{' || c == '[')
                    stack.push(c);
                else{
                    if(!stack.isEmpty() && map.get(stack.peek()) == c){
                        stack.pop();
                        check = true;
                    }
                    else
                        continue;
                }
            }
            if(stack.isEmpty()&&check)
                cnt++;
            sb.append(sb.charAt(0)).deleteCharAt(0);
        }
        return cnt;
    }
}