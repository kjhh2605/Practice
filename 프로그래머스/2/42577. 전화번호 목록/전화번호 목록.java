import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0 ; i < phone_book.length-1 ; i++){
            String cur = phone_book[i];
            String next = phone_book[i+1];
            if(next.length() > cur.length()){
            String nextHead = phone_book[i+1].substring(0,cur.length());
            if(cur.equals(nextHead))
                return false;
            }
        }
        
        return answer;
    }
}