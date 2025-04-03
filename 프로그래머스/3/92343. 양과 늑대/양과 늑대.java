import java.util.*;

class Solution {
    static class Info {
        int sheep, wolf, node;
        HashSet<Integer> visited;

        public Info(int sheep, int wolf, int node, HashSet<Integer> visited) {
            this.sheep = sheep;
            this.wolf = wolf;
            this.node = node;
            this.visited = visited; 
        }
    }

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        ArrayList<Integer>[] field = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            field[start].add(end);
        }

        ArrayDeque<Info> next = new ArrayDeque<>();
        next.add(new Info(1, 0, 0, new HashSet<>()));

        while (!next.isEmpty()) {
            Info cur = next.poll();
            answer = Math.max(answer, cur.sheep); // 매번 최댓값 확인
            cur.visited.addAll(field[cur.node]); // visted 추가

            for (int nextNode : cur.visited) {
                HashSet<Integer> h = new HashSet<>(cur.visited);
                h.remove(nextNode);

                if (info[nextNode] == 0) { 
                    next.add(new Info(cur.sheep + 1, cur.wolf, nextNode, h));
                } else { 
                    if (cur.sheep > cur.wolf + 1) { 
                        next.add(new Info(cur.sheep, cur.wolf + 1, nextNode, h));
                    }
                }
            }
        }

        return answer;
    }
}
