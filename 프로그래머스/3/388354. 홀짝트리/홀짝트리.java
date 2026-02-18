import java.util.*;

class Solution {
    private HashSet<Integer> visited = new HashSet<>();
	public int[] solution(int[] nodes, int[][] edges) {
		int[] answer = new int[2];
		HashMap<Integer,HashSet<Integer>> g = new HashMap<>();
		// 노드 생성
		for(int n : nodes){
			g.put(n,new HashSet<>());
		}
		// 그래프 연결
		for(int[] e : edges){
			int start = e[0];
			int end = e[1];
			// 양방향
			g.get(start).add(end);
			g.get(end).add(start);
		}

		for(int n : nodes){
            if(visited.contains(n)) continue;
            
			int s = check(g,n);
			if(s == 3){
                answer[0]++;
                answer[1]++;
            }else if(s == -1){
                continue;
            }else{
                answer[s]++;
            }
            
		}

		return answer;
	}

	public int check(HashMap<Integer,HashSet<Integer>> g, int startNode){
		ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        visited.add(startNode);
        
		int sameCount = 0; // (번호 == 차수) 홀짝성이 같은 애들
        int diffCount = 0; // (번호 != 차수) 홀짝성이 다른 애들
        
        while(!q.isEmpty()){
            int cur = q.poll();
            int degree = g.get(cur).size(); // 현재 연결된 선의 개수

            if(cur % 2 == degree % 2) {
                sameCount++;
            } else {
                diffCount++;
            }

            for(int next : g.get(cur)){
                if(!visited.contains(next)){
                    visited.add(next);
                    q.add(next);
                }
            }
        }
        
        if(sameCount == 1 && diffCount == 1) return 3;
        if(sameCount == 1) return 0;
        if(diffCount == 1) return 1;
        

        return -1;
		
	}
}