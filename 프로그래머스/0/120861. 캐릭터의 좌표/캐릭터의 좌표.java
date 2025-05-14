class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        for(String input : keyinput){
            switch(input){
                case "left":
                    if(answer[0]-1>=board[0]/2*-1){
                        answer[0]--;
                        break;
                    }else{
                        break;
                    }
                case "right":
                    if(answer[0]+1<=board[0]/2){
                        answer[0]++;
                        break;
                    }else{
                        break;
                    }
                case "up":
                    if(answer[1]+1<=board[1]/2){
                        answer[1]++;
                        break;
                    }else{
                        break;
                    }
                case "down":
                    if(answer[1]-1>=board[1]/2*-1){
                        answer[1]--;
                        break;
                    }else{
                        break;
                    }
            }
        }

        return answer;
    }
}