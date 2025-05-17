import java.util.*;

class Solution {
    private int[][][] status;
    private int n;
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        this.status = new int[n+2][n+2][5];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                Arrays.fill(status[i][j],-1);
            }
        }
        for(int[] build : build_frame){
            check(build);
        }

        ArrayList<int[]> target = new ArrayList<>();
        for(int x = 0 ; x <= n ; x++){
            for(int y = 0 ; y <= n ; y++){
                // 기둥
                if(status[x][y][1]==0)
                    target.add(new int[]{x,y,0});
                // 보
                if(status[x][y][4]==1)
                    target.add(new int[]{x,y,1});
            }
        }

        target.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        return target.stream().toArray(int[][]::new);
    }

    public void check(int[] build){
        int x = build[0];
        int y = build[1];
        int object = build[2];
        int command = build[3];

        if(object==0){
            if(command==1){
                if(canInstallPillar(x, y)){
                    status[x][y][1]=0; // 현재 좌표 위에 기둥
                    status[x][y+1][2]=0; // 위 좌표 아래 기둥
                }
            }else{
                // 삭제
                status[x][y][1]=-1;
                status[x][y+1][2]=-1;
                if(!isValid()){
                    status[x][y][1]=0;
                    status[x][y+1][2]=0;
                }
            }
        }
        if(object==1){
            if(command==1){
                if(canInstallBeam(x, y)){
                    status[x][y][4]=1; // 시작 좌표 오른쪽
                    status[x+1][y][3]=1; // 도착 좌표 왼쪽
                }
            }else{
                status[x][y][4]=-1;
                status[x+1][y][3]=-1;
                if(!isValid()){
                    status[x][y][4]=1;
                    status[x+1][y][3]=1;
                }
            }
        }
    }

    private boolean canInstallPillar(int x, int y){
        // 바닥
        if(y==0) return true;
        // 아래 기둥
        if(status[x][y][2]==0) return true;
        // 왼쪽 보 위
        if(status[x][y][3]==1) return true;
        // 오른쪽 보 위
        if(status[x][y][4]==1) return true;
        return false;
    }

    private boolean canInstallBeam(int x, int y){
        // 보가 바닥에 설치되거나, 범위 밖이면 안됨
        if(y==0 || x==n) return false;
        // 왼쪽 끝에 기둥이 있거나
        if(status[x][y][2]==0) return true;
        // 오른쪽 끝에 기둥이 있거나
        if(status[x+1][y][2]==0) return true;
        // 양쪽에 보가 연결되어 있는 경우
        if(status[x][y][3]==1 && status[x+1][y][4]==1) return true;
        return false;
    }

    private boolean isValid() {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                // 기둥 검사
                if (status[x][y][1] == 0) {
                    if (!canInstallPillar(x, y)) return false;
                }
                // 보 검사
                if (status[x][y][4] == 1) {
                    if (!canInstallBeam(x, y)) return false;
                }
            }
        }
        return true;
    }
}
