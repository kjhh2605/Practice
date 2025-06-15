import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {

        HashMap<String,Integer> h = new HashMap<>();
        for(int i = 0 ; i < friends.length ; i++){
            h.put(friends[i],i);
        }
        int[][] info = new int[friends.length][friends.length];
        for(String gift : gifts){
            String[] tmp = gift.split(" ");
            int a = h.get(tmp[0]);
            int b = h.get(tmp[1]);
            info[a][b]++;
        }
        int[] score = new int[friends.length];
        for(int i = 0 ; i < friends.length ; i++){
            int s = 0;
            for(int j = 0 ; j < friends.length ; j++){
                s += info[i][j];
                s -= info[j][i];
            }
            score[i] = s;
        }

        int[] next = new int[friends.length];
        for(int i = 0 ; i < friends.length ; i++){
            for(int j = i+1 ; j < friends.length ; j++){
                int give = info[i][j];
                int get = info[j][i];
                if (give != get) {          
                    int winner = (give > get) ? i : j;
                    next[winner]++;
                } else {    
                    if (score[i] != score[j]) {
                        int winner = (score[i] > score[j]) ? i : j;
                        next[winner]++;
                    }
                }
            }
        }

        return Arrays.stream(next).max().getAsInt();
    }
}