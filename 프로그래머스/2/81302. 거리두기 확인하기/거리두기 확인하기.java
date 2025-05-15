import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0 ; i < 5 ; i++ ){
            answer[i] = check(places[i]);
        }
        return answer;
    }
    public int check(String string[]){
        String[][] map = new String[5][5];
        //응시자 좌표
        ArrayList<int[]> a = new ArrayList<>();
        for(int i = 0 ; i <  string.length ; i++){
            String[] line = string[i].split("");
            for(int j = 0 ; j < line.length ; j++){
                String v = line[j];
                map[i][j] = v;
                if(v.equals("P"))
                    a.add(new int[]{i,j});
            }
        }
        //거리<=2인 응시자 쌍
        ArrayList<int[]> target = new ArrayList<>();
        for(int i = 0 ; i < a.size() ; i++){
            for(int j = i+1 ; j < a.size() ; j++){
                int[] c = a.get(i);
                int[] b = a.get(j);
                if(getDistance(c,b)<=2)
                    target.add(new int[]{c[0],c[1],b[0],b[1]});
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean f = false;
        for(int i = 0 ; i < target.size() ; i++){
            int[] start = {target.get(i)[0],target.get(i)[1]};
            int[] end = {target.get(i)[2],target.get(i)[3]};
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(start);
            int cnt = 0;
            while(!q.isEmpty()){
                if(cnt>2 || f) // 돌아서 가면 거리 유지 O
                    break;
                cnt++;
                int size = q.size();
                for(int n = 0 ; n < size ; n++){
                int[] cur = q.poll();
                int x = cur[1];
                int y = cur[0];
                for(int j = 0 ; j < 4 ; j++){
                    int newX = x+dx[j];
                    int newY = y+dy[j];
                    if(newX < 0 || newY < 0 || newX > 4 || newY > 4 || (newX == start[1] && newY == start[0]))
                        continue;
                    if(map[newY][newX].equals("X"))
                        continue;
                    if(newX==end[1] && newY==end[0]){
                        f = true;
                        break;
                    }
                    q.add(new int[]{newY,newX});
                }
            }
            }
            if(f){
                break;
            }
        }
        
        return f?0:1;
    }
    public int getDistance(int[] a, int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}