import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[]g = new ArrayList[n+1];
        for(int i = 1 ; i < g.length ; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] a : edge){
            int start = a[0];
            int end = a[1];
            g[start].add(end);
            g[end].add(start);
        }
        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        int visitCnt=1;
        while(!q.isEmpty()){
            if(visitCnt==n)
                break;
            answer=0;
            int l = q.size();
            for(int j = 0 ; j < l ;j++){
            int cur = q.poll();
            for(int i = 0 ; i < g[cur].size() ; i++){
                if(!visited[g[cur].get(i)]){
                    q.add(g[cur].get(i));
                    visited[g[cur].get(i)] = true;
                    visitCnt++;
                    answer++;
                }
            }
            }
        }
        
        
        return answer;
    }
}