import java.util.*;
class Solution {
    public int n;
    public int user_n;
    public int answer;
    public int[] tmp;
    public HashSet<String> h;
    public int solution(String[] user_id, String[] banned_id) {
        this.n = banned_id.length;
        this.user_n = user_id.length;
        this.tmp = new int[n];
        this.h = new HashSet<>();
        ArrayList<Integer>[] candidate = new ArrayList[banned_id.length];
        for(int i = 0 ; i < candidate.length ; i++){
            candidate[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < banned_id.length ; i++){
            char[] target = banned_id[i].toCharArray();
            for(int j = 0 ; j < user_id.length ; j++){
                char[] s = user_id[j].toCharArray();
                if(target.length == s.length){
                    boolean flag = true;
                    for(int k = 0 ; k < target.length ; k++){
                        if(target[k]=='*')
                            continue;
                        if(target[k]!=s[k])
                            flag = false;
                    }
                    if(flag)
                        candidate[i].add(j);
                }
            }
            boolean[] visited = new boolean[user_id.length];
            dfs(0,visited,candidate);
        }    
        return answer;
    }
    public void dfs(int degree, boolean[]visited , ArrayList<Integer>[] candidate){
        if(degree==n){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < user_n ; i++){
                sb.append("X");   
            }
            for(int i : tmp){
                sb.setCharAt(i,'O');
            }
            String s = sb.toString();
            if(!h.contains(s)){
                h.add(s);
                answer++;
            }
            return;
        }
        for(int i = 0 ; i < candidate[degree].size() ; i++){
            int idx = candidate[degree].get(i);
            if (!visited[idx]) {
                visited[idx] = true;
                tmp[degree] = idx;
                dfs(degree + 1, visited, candidate);
                visited[idx] = false;
            }
        
        }
        
    }
}