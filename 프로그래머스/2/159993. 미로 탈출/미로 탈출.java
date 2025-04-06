import java.util.*;
class Solution {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int dfs(int[] start, String destination, String[][]maze){
        int time = -1;
        int[] cur = start;
         
        ArrayDeque<int[]>q = new ArrayDeque<>();
        boolean[][]visited = new boolean[maze.length][maze[0].length];
        visited[start[1]][start[0]] = true;
        q.add(cur);
        
        
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                cur = q.poll();
                
                for(int j = 0 ; j < 4 ; j++){
                    int x = cur[0]+dx[j];
                    int y = cur[1]+dy[j];
                    if(x>=maze[0].length || y >=maze.length || x < 0 || y <0 || visited[y][x] || maze[y][x].equals("X"))
                        continue;
                    if(maze[y][x].equals(destination))
                        return time+1;
                    visited[y][x] = true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        String[][]maze = new String[maps.length][maps[0].length()];
        int[] cur = new int[2];
        int[] lever = new int[2];
        boolean isFound = false;
        for(int i = 0 ; i < maze.length ; i++){
            String[] line = maps[i].split("");
            for(int j = 0 ;  j < line.length ; j++){
                maze[i][j] = line[j];
                if(line[j].equals("S")){
                    cur[0] = j; // x
                    cur[1] = i; // y
                }else if(line[j].equals("L")){
                    lever[0] = j;
                    lever[1] = i;
                }
            }
        }
        
        int a = dfs(cur,"L",maze);
        int b = dfs(lever,"E",maze);
        
        
        return a!=-1&&b!=-1?a+b:-1;
    }
}