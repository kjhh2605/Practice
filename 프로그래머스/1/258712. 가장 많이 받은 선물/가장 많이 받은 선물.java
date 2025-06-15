import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {

        HashMap<String,Integer> h = new HashMap<>();
        HashMap<Integer,Integer> next = new HashMap<>();
        for(int i = 0 ; i < friends.length ; i++){
            h.put(friends[i],i);
            next.put(i,0);
        }
        int[][] info = new int[friends.length][friends.length];
        for(String gift : gifts){
            String[] tmp = gift.split(" ");
            int a = h.get(tmp[0]);
            int b = h.get(tmp[1]);
            info[a][b]++;
        }
        HashMap<Integer,Integer> score = new HashMap<>();
        for(int i = 0 ; i < friends.length ; i++){
            int s = 0;
            for(int j = 0 ; j < friends.length ; j++){
                s += info[i][j];
                s -= info[j][i];
            }
            score.put(i,s);
        }
        
        for(int i = 0 ; i < friends.length ; i++){
            for(int j = 0 ; j < friends.length ; j++){
                int give = info[i][j];
                int get = info[j][i];
                if(give > get){
                    // 기록 있으면
                    next.put(i,next.get(i)+1);
                }else if(give < get){
                    next.put(j,next.get(j)+1);
                }else{
                    if(score.get(i) > score.get(j)){
                        next.put(i,next.get(i)+1);
                    }else if(score.get(i) < score.get(j)){
                        next.put(j,next.get(j)+1);
                    }else{
                        continue;
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < friends.length ; i++){
            if(next.get(i) > answer){
                answer = next.get(i);
            }
        }
        return answer/2;
    }
}