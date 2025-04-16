
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        //희망 시간 +-10분
        //토요일 일요일은 이벤트 영향x
        //1:월 ~ 7:일
        for(int i = 0 ; i < timelogs.length ; i++){
            int standard = schedules[i];
            int end = 0;
            if(standard%100 >= 50)
                end = standard+100-standard%100 + 10 - (60-standard%100);
            else
                end = standard+10;
            int day = startday;
            int cnt = 0;
            boolean flag = true;
            for(int j = 0 ; j < timelogs[i].length ; j++){
                int cur = timelogs[i][j];
                if(day!=6 && day!=7){
                    if(cur > end){
                        flag = false;
                        break;
                        
                    }
                }
                day++;
                if(day>7)
                    day = 1;
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}