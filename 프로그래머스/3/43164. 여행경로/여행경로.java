import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    HashMap<String, PriorityQueue<String>> g = new HashMap<>();

    public String[] solution(String[][] tickets) {
        for (String[] s : tickets) {
            String start = s[0];
            String end = s[1];
            if (!g.containsKey(start)) {
                g.put(start, new PriorityQueue<>());
                g.get(start).add(end);
            } else {
                g.get(start).add(end);
            }
        }
        
        dfs("ICN");
        
        Collections.reverse(result);
        return result.toArray(new String[0]);
    }

    private void dfs(String start) {
        if(!g.containsKey(start)){
            result.add(start);
            return;
        }   
        
        PriorityQueue<String> next = g.get(start);
        while (!next.isEmpty()) {
            dfs(next.poll()); 
        }

        result.add(start);
    }
}