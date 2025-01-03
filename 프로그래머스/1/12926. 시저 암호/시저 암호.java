class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i<s.length() ; i++){
            char tmp = s.charAt(i);
            if(tmp == ' '){//공백
                answer += tmp;
                continue;
            }
            
            if(tmp >= 'a' && tmp <= 'z'){
                tmp += n;
                if(tmp > 'z')
                    tmp -= 26;
            }
            if(tmp >= 'A' && tmp <= 'Z'){
                tmp += n;
                if(tmp > 'Z')
                    tmp -= 26;
            }
            
            answer += tmp;
        }
        return answer;
    }
}