import java.util.*;
class Solution {
    public int answer;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(visited,dungeons,0,k,0);
        return answer;
    }
    public void dfs(boolean[] visited,int[][]dungeons,int curD, int curStatus, int depth){
        for(int i = 0 ; i < dungeons.length ; i++){
            int needStatus = dungeons[i][0];
            int cost = dungeons[i][1];
            if(!visited[i] && needStatus <= curStatus){
                visited[i] = true;
                curStatus -= cost;
                depth++;
                for(int j = 0 ; j < dungeons.length ; j++){
                    if(!visited[j]){
                        dfs(visited,dungeons,j,curStatus,depth);
                    }
                }
                if(depth > answer)
                    answer = depth;
                visited[i] = false;
                curStatus += cost;
                depth--;

            }
        }
    }
}