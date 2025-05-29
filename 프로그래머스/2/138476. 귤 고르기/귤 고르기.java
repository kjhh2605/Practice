import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int max = tangerine[tangerine.length-1];
        int[] cnt = new int[max];
        for(int i : tangerine){
            cnt[i-1]++;
        }
        Arrays.sort(cnt);
        for(int i = cnt.length-1 ; i > -1 ; i--){
            if(k<=0)
                break;
            k-=cnt[i];
            answer++;
        }
        return answer;
    }
}