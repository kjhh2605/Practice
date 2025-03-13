import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int first(int[][] paper, int n, int m) {
        int sum = 0;

        for (int j = 0; j <= m - 4; j++) { // 가로로
            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int k = 0; k < 4; k++) {
                    tmp += paper[i][j + k];
                }
                if (tmp > sum)
                    sum = tmp;
            }
        }
        for (int i = 0; i <= n - 4; i++) { // 세로로
            for (int j = 0; j < m; j++) {
                int tmp = 0;
                for (int k = 0; k < 4; k++) {
                    tmp += paper[i + k][j];
                }
                if (tmp > sum)
                    sum = tmp;
            }
        }
        return sum;
    }

    static int second(int[][] paper, int n, int m) {
        int sum = 0;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <=m - 2; j++) {
                int tmp = 0;
                for (int k = 0; k < 2; k++) {
                    for (int t = 0; t < 2; t++) {
                        tmp += paper[i + k][j + t];
                    }
                }
                if (tmp > sum)
                    sum = tmp;
            }
        }
        return sum;
    }

    static int third(int[][] paper, int n, int m){
        int[] d = {1,-1};
        int sum = 0;
        for(int i = 0 ; i <= n-3 ; i++){ // 세로로
            for(int j = 0; j < m ; j++){
                int tmp = 0;
                for(int k = 0 ; k < 3 ; k++){
                   tmp += paper[i+k][j]; // 세로 3개
                }
                int t = 0;
                for(int a = 0 ; a < 3 ; a++){ // 높이3
                    for(int b = 0 ; b < 2 ; b++){ // 좌,우
                        if(j+d[b] < 0 || j+d[b] >= m)
                            continue;
                        if(paper[i+a][j+d[b]] > t)
                            t = paper[i+a][j+d[b]];
                    }
                }
                if(tmp+t > sum)
                    sum = tmp+t;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j <= m-3 ; j++){ // 가로로
                int tmp = 0;
                for(int k = 0 ; k < 3 ; k++){
                    tmp += paper[i][j+k];
                }
                int t = 0;
                for(int a = 0 ; a < 3 ; a++){ // 길이3
                    for(int b = 0 ; b < 2 ; b++){ // 상,하
                        if(i+d[b] < 0 || i+d[b] >= n)
                            continue;
                        if(paper[i+d[b]][j+a] > t)
                            t = paper[i+d[b]][j+a];
                    }
                }
                if(tmp+t > sum)
                    sum = tmp+t;
            }
        }

        return sum;
    }
    static int fourth(int[][]map, int n, int m){
        int sum = 0;
        int[] d = {0,2};
        for(int i = 0 ; i <= n-3 ; i++){
            for(int j = 0 ; j <= m-3 ; j++){
                int tmp = map[i+1][j+1]+map[i+1][j+2]; // 가운데 가로2
                int t = 0;
                for(int a = 0; a < 2 ; a++){
                    if(i+d[a]<0 || i+d[a]>=n)
                        continue;
                    int tt = map[i+d[a]][j]+map[i+d[a]][j+1];
                    if(tt>t)
                        t = tt;
                }
                for(int a = 0; a < 2 ; a++){
                    if(i+d[a]<0 || i+d[a]>=n || j+3 >= m)
                        continue;
                    int tt = map[i+d[a]][j+2]+map[i+d[a]][j+3];
                    if(tt>t)
                        t = tt;
                }
                if(tmp+t > sum)
                    sum =tmp+t;
            }
        }

        for(int i = 0 ; i <= n-3 ; i++){
            for(int j = 0 ; j <= m-3 ; j++){
                int tmp = map[i+1][j+1]+map[i+2][j+1]; // 가운데 세로2
                int t = 0;
                for(int a = 0; a < 2 ; a++){
                    if(j+d[a] < 0 || j+d[a] >= m)
                        continue;
                    int tt = map[i][j+d[a]]+map[i+1][j+d[a]];
                    if(tt>t)
                        t = tt;
                }
                for(int a = 0; a < 2 ; a++){
                    if(j+d[a] < 0 || j+d[a] >= m || i+3 >= n)
                        continue;
                    int tt = map[i+2][j+d[a]]+map[i+3][j+d[a]];
                    if(tt>t)
                        t = tt;
                }
                if(tmp+t > sum)
                    sum =tmp+t;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        int a = first(paper, n, m);
        int b = second(paper, n, m);
        int c = third(paper,n,m);
        int d = fourth(paper,n,m);
        int answer = Math.max(Math.max(a,b),Math.max(c,d));
        System.out.println(answer);
    }
}
