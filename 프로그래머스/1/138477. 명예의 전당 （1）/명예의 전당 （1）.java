import java.util.Collections;
import java.util.Vector;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        Vector<Integer> rank = new Vector(); 
        
        for(int i = 0 ; i < score.length ; i++ ){   
            if(rank.size()==k){
                if(rank.get(0)>=score[i]){//랭킹 갱신 안되면
                answer[i] = rank.get(0);
                continue;
                }
                else{
                    rank.set(0,score[i]);//작은 값 지우고 새 값 추가
                    Collections.sort(rank);
                    answer[i] = rank.get(0);
                    continue;
                }
            }
            
            rank.add(score[i]);
            Collections.sort(rank);
            answer[i] = rank.get(0);
        }
        
        return answer;
    }
}