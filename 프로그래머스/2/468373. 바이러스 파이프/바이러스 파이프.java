import java.util.*;

class Solution {
    int answer = 0;
    int n;
    List<Integer>[][] adj;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        adj = new ArrayList[4][n + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= n; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int type = e[2];
            adj[type][x].add(y);
            adj[type][y].add(x);
        }

        boolean[] checked = new boolean[n + 1];
        checked[infection] = true;

        List<Integer> infectedNodes = new ArrayList<>();
        infectedNodes.add(infection);

        dfs(0, k, checked, infectedNodes);

        return answer;
    }

    private void dfs(int degree, int max, boolean[] checked, List<Integer> infectedNodes) {
        answer = Math.max(answer, infectedNodes.size());

        if (degree == max || infectedNodes.size() == n) {
            return;
        }

        for (int type = 1; type <= 3; type++) {
            Queue<Integer> q = new ArrayDeque<>();
            List<Integer> newlyInfected = new ArrayList<>(); 

            for (int node : infectedNodes) {
                if (!adj[type][node].isEmpty()) {
                    q.add(node);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : adj[type][cur]) {
                    if (!checked[next]) {
                        checked[next] = true;
                        newlyInfected.add(next);
                        q.add(next);
                    }
                }
            }

            if (!newlyInfected.isEmpty()) {
                List<Integer> nextInfectedNodes = new ArrayList<>(infectedNodes);
                nextInfectedNodes.addAll(newlyInfected);

                dfs(degree + 1, max, checked, nextInfectedNodes);

                for (int node : newlyInfected) {
                    checked[node] = false;
                }
            }
        }
    }
}