import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0 ; i < commands.length ; i++){
            a.clear();
            for(int j = commands[i][0]-1 ; j < commands[i][1] ; j++){
                a.add(array[j]);
            }
            a.sort(null);
            answer[i] = a.get(commands[i][2]-1);
        }
        return answer;
    }
}