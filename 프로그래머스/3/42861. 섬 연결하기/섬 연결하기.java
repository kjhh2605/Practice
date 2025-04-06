import java.util.*;
class Solution {
    public static void union(int[]parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        
        if(rootA != rootB)
            parent[rootA] = rootB;
    }
    
    public static int find(int[]parent, int v){
        if(parent[v]==v)
            return v;
        else
            return find(parent,parent[v]);
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[101];
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0 ; i < costs.length ; i++){
            int[] cur = costs[i];
            if(find(parent,cur[0])!=find(parent,cur[1])){
                union(parent,cur[0],cur[1]);
                answer+=cur[2];
            }
        }
        return answer;
    }
}