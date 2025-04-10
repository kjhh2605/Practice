import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] weight = new int[N+1][N+1];
        for(int[] i : weight){
            Arrays.fill(i,-1);
        }
        for(int[] i : road){
            if(weight[i[0]][i[1]] > i[2] || weight[i[0]][i[1]] == -1){
                weight[i[0]][i[1]] = i[2]; 
                weight[i[1]][i[0]] = i[2];
            }
        }
        int[] time = new int[N+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[1] = 0;
        
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll(); //0노드 1은 비용
            if(cur[1] > time[cur[0]])
                continue;
            for (int i = 1; i <= N; i++) {
                if (weight[cur[0]][i] != -1) { //연결되어있고
                    int tmp = cur[1] + weight[cur[0]][i];
                    if (tmp < time[i]) {
                        time[i] = tmp;
                        pq.add(new int[]{i, tmp});
                    }
                }
            }            
        }
        for(int t : time){
            if(t <= K)
                answer++;
        }
        
        return answer;
    }
}