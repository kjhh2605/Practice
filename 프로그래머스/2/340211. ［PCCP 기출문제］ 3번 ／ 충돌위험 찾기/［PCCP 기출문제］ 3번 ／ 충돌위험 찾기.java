import java.sql.Array;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        ArrayList<int[]>[] robots = new ArrayList[routes.length];
        for(int i = 0 ; i < robots.length ; i++){
            robots[i] = new ArrayList<>();
            for(int j = 0 ; j < routes[0].length-1 ; j++){
                int[] dis = getDistance(points, routes[i][j], routes[i][j+1]);
                robots[i].add(dis);
            }
        }

        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> tmpSet = new HashSet<>();
        
        int[][] cur = new int[robots.length][2];
        for (int i = 0; i < cur.length; i++) {
            cur[i] = new int[]{points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]};
            Integer t = cur[i][0]*1000 + cur[i][1];
            if(set.contains(t) && !tmpSet.contains(t)){
                    answer++;
                    tmpSet.add(t);
            }
            set.add(t);
        }
        set.clear();
        tmpSet.clear();

        while(true){

            int flagCnt = 0;
            
            for(int i = 0 ; i < robots.length ; i++){ // 각 로봇에 대해
                if(robots[i].isEmpty()){
                    flagCnt++;
                    continue;
                }

                int[] tmp = robots[i].get(0);

                if(tmp[0] != 0){ // y축 우선 이동
                    if(tmp[0] > 0){
                        cur[i][0]++;
                        robots[i].get(0)[0]--;
                    }else if(tmp[0] < 0){
                        cur[i][0]--;
                        robots[i].get(0)[0]++;
                    }
                }else{ // 그다음 x축 이동
                    if(tmp[1] > 0){
                        cur[i][1]++;
                        robots[i].get(0)[1]--;
                    }else if(tmp[1] < 0){
                        cur[i][1]--;
                        robots[i].get(0)[1]++;
                    }
                }

                Integer t = cur[i][0]*1000+cur[i][1];
                if(set.contains(t) && !tmpSet.contains(t)){
                    answer++;
                    tmpSet.add(t);
                }
                set.add(t);
                if(tmp[0] == 0 && tmp[1] == 0){ // 도착했으면 목적지 제거
                    robots[i].remove(0);
                }

            }
            set.clear();
            tmpSet.clear();
            if(flagCnt == robots.length)
                break;
        }


        return answer;
    }

    public int[] getDistance(int[][]points , int start, int end){
        int x = points[end-1][1]-points[start-1][1];
        int y = points[end-1][0]-points[start-1][0];
        return new int[]{y,x};
    }
}