import java.util.PriorityQueue;

class Solution {
    class Node{
        int x,y,cost;
        Node(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};
    public int solution(int[][] land, int height) {
        int answer = 0;
        int len = land.length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Node(0,0,0));

        boolean[][] visited = new boolean[len][len];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            if(visited[y][x])
                continue;
            visited[y][x] = true;
            answer+=cur.cost;

            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 ||  newX >= len || newY < 0 || newY >= len)
                    continue;
                int cost = Math.abs(land[newY][newX]-land[y][x]);
                if(cost <= height)
                    cost = 0;
                pq.add(new Node(newX,newY,cost));
            }

        }
        return answer;
    }
}