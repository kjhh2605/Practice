class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for(int i = 1 ; i < land.length ; i++){
            int[] before = land[i-1];
            for(int j = 0 ; j < 4 ; j++){
                int tmp = 0;
                for(int k = 0 ; k < 4; k++){
                    if(before[k]>tmp&&k!=j)
                        tmp = before[k];
                }
                land[i][j]+=tmp;
            }
        }
        for(int i : land[land.length-1]){
            if(i>answer)
                answer=i;
        }
        return answer;
    }
}