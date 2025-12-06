import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];// 추가한 정점, 도넛, 막대, 8자
        
        // 모두 하나씩은 연결됨
        // 뻗어 나가기만 하면 추가된 정점
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        HashSet<Integer> ends = new HashSet<>();
        HashSet<Integer> starts = new HashSet<>();
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            
            if(!g.containsKey(a)){
                g.put(a,new ArrayList<>());
                g.get(a).add(b);
            }else{
                g.get(a).add(b);
            }
            
            starts.add(a);
            ends.add(b);
        }
        
        for(int i : starts){
            if(!ends.contains(i) && g.get(i).size()>=2){
                answer[0] = i;
                break;
            }
        }
        
        for(int i : g.get(answer[0])){
            int start = i; // 그래프 탐색 시작점
            int cnt = 0;
            int cur = start;
            boolean flag = false;
            
            while(cnt<2){
                if(cur==start){
                    cnt++;
                }
                
                if(!g.containsKey(cur)){ // 막대
                    answer[2]++;
                    flag = true;
                    break;
                }
                
                if(g.get(cur).size()==2){ // 8자
                    answer[3]++;
                    flag = true;
                    break;
                }
                
                cur = g.get(cur).get(0);
            }
            
            if(!flag){ // 도넛
                answer[1]++;
            }
        }
        
        return answer;
    }
}