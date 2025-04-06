import java.util.*;
class Solution {
    public static int find(int n, int[] parent){
        while(parent[n] != n){
                n = parent[n];
        }
        return n;
    }
    public int solution(int n, int[][] computers) {
        int[] parent = new int[computers.length];
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < computers.length ; i++){
            int[]computer = computers[i];
            for(int j = 0 ; j < computer.length && i!=j  ; j++){
                if(computer[j]==1 && find(i,parent)!=find(j,parent)){
                    parent[find(j,parent)] = parent[find(i,parent)];
                }
            }
        }
        
        HashSet<Integer> network = new HashSet<>();
        for(int i = 0 ; i < computers.length ; i++){
            network.add(find(i,parent));
        }
        return network.size();
    }
}