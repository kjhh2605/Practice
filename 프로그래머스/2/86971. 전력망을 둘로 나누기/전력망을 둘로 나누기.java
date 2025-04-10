import java.util.*;
class Solution {
    public int dfs(int[][] g , int start , int n){
        boolean[] visited = new boolean[n+1];
        int cnt = 0 ;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            cnt++;
            for(int i = 1 ; i <= n ; i++){
                if(g[cur][i] == 1 && !visited[i]){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] g = new int[n+1][n+1];
        for(int[] wire : wires){
            g[wire[0]][wire[1]] = 1;
            g[wire[1]][wire[0]] = 1;
        }
        for(int[] wire : wires){
            g[wire[0]][wire[1]] = 0;
            g[wire[1]][wire[0]] = 0;
            
            int size = dfs(g,wire[0],n);
            int tmp = Math.abs((n-size)-size);
            if(answer>tmp)
                answer = tmp;
            
            g[wire[0]][wire[1]] = 1;
            g[wire[1]][wire[0]] = 1;
        }
        return answer;
    }
}