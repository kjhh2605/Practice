import java.util.*;

class Solution {
    public int solution(int[][] routes) {
    
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int camera = routes[0][1];
        int cnt = 1;

        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                cnt++;
            }
        }

        return cnt;
    }
}
