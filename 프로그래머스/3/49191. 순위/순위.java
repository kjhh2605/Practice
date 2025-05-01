class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] g = new int[n+1][n+1];
        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            g[a][b] = 1;
            g[b][a] = -1;
        }
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){ // j는 i열의 대상
                for(int k = 1 ; k < n+1 ; k++){// k는 j의 상대
                    if(g[j][i] == 1 && g[i][k] == 1){
                        g[j][k] = 1;
                        g[k][j] = -1;
                    }
                }
            }
        }
        for(int i = 1 ; i < n+1 ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= n ; j++){
                if(g[i][j] != 0)
                    cnt++;
            }
            if(cnt == n-1)
                answer++;
        }
        return answer;
    }
}