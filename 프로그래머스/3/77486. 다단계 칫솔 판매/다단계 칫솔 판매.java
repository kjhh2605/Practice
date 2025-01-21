import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String,String> refList = new HashMap();
        HashMap<String,Integer> profList = new HashMap();
        
        for(int i = 0 ; i < enroll.length ; i++){
                refList.put(enroll[i],referral[i]); // 판매원 - 추천인
                profList.put(enroll[i],0); // 판매원 - 수익
        }
        
        for(int i = 0 ; i < seller.length ; i++){
            String ref = refList.get(seller[i]); // 판매자의 추천인
            int profit = amount[i] * 100;
            String s = seller[i]; // 현재 위치
    
            if(ref.equals("-")){
                int curProfit = profList.get(s); // 현재 수익
                if(profit/10 < 1){ // 10%가 1원 미만인 경우
                    profList.replace(s,curProfit + profit); // 자신이 전부 가짐
                    break;
                }
                
                //profit /= 10; // 10%는 원 단위에서 절사 -> int
                int bonus = profit/10;
                profList.replace(s,curProfit + profit - bonus); // 90%만 추가하고
                profit /= 10;
                continue;
            }
            
            while(!ref.equals("-")){ // 추천인이 있으면
                int curProfit = profList.get(s); // 현재 수익
                if(profit/10 < 1){
                    profList.replace(s,curProfit + profit); 
                    break;
                }
                int bonus = profit/10;
                profList.replace(s,curProfit + profit - bonus); // 90%만 추가하고
                profit /= 10;
                ref = refList.get(s); 
                s = refList.get(s); // 이동
            }
        }
        
        for(int i = 0 ; i < enroll.length ; i++){
            int s = profList.get(enroll[i]);
            answer[i] = s;
        }
            
        return answer;
    }
}