import java.util.*;
class Solution {
    public int solution(int[][] land) {
        // 땅 500*100
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < land.length ; i++){
            for(int j = 0 ;  j < land[0].length ; j++){
                if(land[i][j]==1){
                    list.add(new int[]{i,j});
                }
            }
        }
        boolean[][] checked = new boolean[land.length][land[0].length];
        int[] mass = new int[50011]; // 10번 부터 시작
        int idx = 10;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1, 0,0};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int[] a : list){
            q.clear();
            if(checked[a[0]][a[1]]) //방문했으면 건너뛰고
                continue;
            
            q.add(a);// 아니면 bfs
            checked[a[0]][a[1]]=true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int curX = cur[1];
                int curY = cur[0];
                land[curY][curX] = idx;
                mass[idx]++;

                for(int i = 0 ; i < 4 ; i++){
                    int newX = curX + dx[i];
                    int newY = curY + dy[i];
                    if(newX < 0 || newY < 0 || newX >= land[0].length || newY >= land.length || checked[newY][newX])
                        continue;
                    if(land[newY][newX]==1){
                        q.add(new int[]{newY,newX});
                        checked[newY][newX] = true;
                    }
                }

            }
            idx++;
        }
        int answer = 0;
        HashSet<Integer> history = new HashSet<>();
        for(int i = 0 ; i < land[0].length ; i++){
            int cnt = 0 ;
            history.clear();
            for(int j = 0 ;  j < land.length ; j++){
                if(land[j][i]!=0 && !history.contains(land[j][i])){
                    history.add(land[j][i]);
                    cnt+=mass[land[j][i]];
                }
            }
            if(cnt>answer)
                answer = cnt;
        }
        return answer;
    }
}