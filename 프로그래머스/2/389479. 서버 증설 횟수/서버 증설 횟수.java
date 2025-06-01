class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int cur = 1;
        int[]server = new int[24];
        
        for(int i = 0 ; i < players.length ; i++){
            if(i-k >= 0){
                cur-=server[i-k]; 
            }
            int pos = cur*m; 
            while(pos<=players[i]){
                pos+=m;
                answer++;
                cur++;
                server[i]++;
            }
        }
        return answer;
    }
}