import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            if(c == ')'){
                if(stack.isEmpty() || stack.peek() == ')')
                    return false;
                else
                    stack.pop();
            }   
        }
        return stack.isEmpty()?true:false;
    }
}