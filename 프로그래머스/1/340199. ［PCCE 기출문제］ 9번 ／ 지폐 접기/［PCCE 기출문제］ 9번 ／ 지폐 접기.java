class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wX = wallet[0];
        int wY = wallet[1];
        int bX =  bill[0];
        int bY = bill[1];
        
        
        while(true){
           if (Math.min(wX, wY) >= Math.min(bX, bY) && Math.max(wX, wY) >= Math.max(bX, bY)) {
                break;
            }
            
            if (bX >= bY) {
                bX /= 2;
            } else {
                bY /= 2;
            }
            answer++;
        }
        
        return answer;
    }
}