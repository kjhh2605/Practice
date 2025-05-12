class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tmp = (brown+4)/2;
        if(tmp%2==0){
            answer[0] = tmp/2;
            answer[1] = tmp/2;
        }else{
            answer[0] = tmp/2+1;
            answer[1] = tmp/2;
        }
        
        while(answer[1]>0){
            for(int i = 1 ; i <= yellow ; i++){
                if(yellow%i==0){
                    int a = i;
                    int b = yellow / i;
                    if(answer[0]-b==2 && answer[1]-a==2)
                        return answer;
                }
            }
            
            answer[0]++;
            answer[1]--;
        }
        
        return answer;
    }
}