import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        int answer = n - lost.length; //안 잃어버린 학생 수 
        
         for(int i = 0 ; i<lost.length ; i++){
            for(int j = 0 ; j<reserve.length ; j++){
                if(reserve[j] == lost[i]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++; //잃어버렸지만 여벌 있는 학생
                    break;
                }       
            }
        }
        
          for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
					reserve[j] = -1;
                    answer++; //다른 학생한테 빌린 학생
					break;
				}
			}
		}
        
         
        return answer;
    }
}