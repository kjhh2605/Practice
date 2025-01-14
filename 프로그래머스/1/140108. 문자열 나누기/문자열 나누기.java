class Solution {
    public int solution(String s) {
        int answer = 0;
        Character x = null ;
        int xCnt = -1;
        int oCnt = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            if(x == null){ // 첫 문자설정 
                System.out.print(i);
                x = s.charAt(i);
                System.out.println(x);
                xCnt++;
            }
            
            if(x == s.charAt(i))
                xCnt++;
            else
                oCnt++;
            if(xCnt == oCnt){
                answer++;
                xCnt = -1;
                oCnt = 0;
                x = null;
                continue;
            }
            
            if(i == s.length()-1)
                answer++;
        }
        
        return answer;
    }
}