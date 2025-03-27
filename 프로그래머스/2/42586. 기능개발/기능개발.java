import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < progresses.length ; i++){
            int time = 0;
            while(progresses[i] < 100){
                time++;
                progresses[i]+=speeds[i];
            }
            q.add(time);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        int standard = q.poll(); // 첫 작업
        while(!q.isEmpty()){
            int i = q.poll();
            if(i <= standard){
                cnt++;
            }else{
                list.add(cnt);
                cnt=1;
                standard = i;
            }
            if(q.isEmpty())
                list.add(cnt);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}