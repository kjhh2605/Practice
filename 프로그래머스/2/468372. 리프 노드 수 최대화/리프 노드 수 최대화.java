class Solution {
    private int answer=0;

    public int solution(int dist_limit, int split_limit) {
        // dist_limit : 분배 노드 수 제한
        // split_limit : 분배도 제한
        
        dfs(1, 0, 1, dist_limit, split_limit);
        
        return answer;
    }

    // distCnt : 분배 노드 수
    // split : 분배도
    private void dfs(int cur, int distCnt, int split, int dist_limit, int split_limit) {

        if (cur > answer) {
            answer = cur;
        }
        
        if((long)split*2 <= split_limit){
            int possible_dist_cnt = dist_limit - distCnt;
            
            if(cur > possible_dist_cnt){
                int remaining = cur - possible_dist_cnt;
                dfs(remaining + possible_dist_cnt*2,distCnt+possible_dist_cnt,split*2,dist_limit,split_limit);
            }else{
                dfs(cur*2, distCnt+cur, split*2, dist_limit, split_limit);
            }
        }
        
        if((long)split*3 <= split_limit){
            int possible_dist_cnt = dist_limit - distCnt;
            
            if(cur > possible_dist_cnt){
                int remaining = cur - possible_dist_cnt;
                dfs(remaining + possible_dist_cnt*3,distCnt+possible_dist_cnt,split*3,dist_limit,split_limit);
            }else{
                dfs(cur*3, distCnt+cur, split*3, dist_limit, split_limit);
            }
        }
        
    }
}