class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        boolean isPossible = true;
        int c1 = 0;
        int c2 = 0;
        for(String str : goal){
            if(c1 < cards1.length && str.equals(cards1[c1])){
                c1++;
                continue;
            }
            if(c2 < cards2.length && str.equals(cards2[c2])){
                c2++;
                continue;
            }
            isPossible = false;
            break;
        }
        
        if(isPossible){
            answer = "Yes";
        }else{
            answer = "No";
        }
            
        
        
        
        return answer;
    }
}