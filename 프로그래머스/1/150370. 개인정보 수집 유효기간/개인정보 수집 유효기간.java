import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] td = today.split("\\.");

        // +유효기간 -1일 (0이면 이전달 28일)
        HashMap<String,Integer> term = new HashMap<>();
        for(String t : terms){
            String[] tmp = t.split(" ");
            term.put(tmp[0],Integer.parseInt(tmp[1]));
        }
        int n = 0;
        for(String p : privacies){
            n++;
            String[] tmp = p.split(" ");// 날짜, 약관
            String[] date = tmp[0].split("\\.");//연도,월,일
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            month += term.get(tmp[1]);

            int mToY = 0;
            if(month > 12){
                mToY = month/12;
                month %= 12;
                if(month==0){
                    month=12;
                    year--;
                }
            }

            year+=mToY;
            day--;
            if(day==0){
                day=28;
                month--;
            }

            int todayNum = Integer.parseInt(td[0]) * 10000 + Integer.parseInt(td[1]) * 100 + Integer.parseInt(td[2]);
            int expireNum = year * 10000 + month * 100 + day;

            if (expireNum < todayNum) {
                answer.add(n);
            }

        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}