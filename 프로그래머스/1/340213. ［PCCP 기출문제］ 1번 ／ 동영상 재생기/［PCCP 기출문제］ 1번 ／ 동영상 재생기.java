class Solution {
    int posToInt(String s){
        return Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
    }
    String intToPos(int i){
        if(i == 0)
            return "00:00";
        else{
            int min = i/60;
            int sec = i%60;
            String mm = String.valueOf(min);
            String ss = String.valueOf(sec);
            if(mm.length() == 1){
                String tmp = "0"+mm;
                mm = tmp;
            }
            if(ss.length() == 1){
                String tmp = "0"+ss;
                ss = tmp;
            }
            return mm+":"+ss;
            
        }
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int curTime = posToInt(pos);
        int opStart = posToInt(op_start);
        int opEnd = posToInt(op_end);
        int autoNext = opEnd - opStart;// 오프닝시간 
        int vLength = posToInt(video_len);
        
        if(curTime >= opStart && curTime < opEnd)//오프닝 건너뛰기
            curTime = opEnd;
        
        for(String command : commands){
            if(command.equals("next")){
                int start = curTime;
                curTime += 10;
                if((start <= opStart && curTime >= opEnd) || curTime == opStart) // 오프닝 포함 or 오프닝 경계
                    curTime += autoNext;
                
                if(curTime > vLength)
                    curTime = vLength;
                else if(curTime > opStart && curTime < opEnd) // 오프닝 건너뛰기
                    curTime = opEnd;
            }
            else if(command.equals("prev")){
                int start = curTime;
                curTime -= 10;
                if((curTime <= opStart && start >= opEnd) || curTime == opEnd)
                    curTime -= autoNext;
                
                if(curTime < 0)
                    curTime = 0;
                else if(curTime >= opStart && curTime < opEnd) // 오프닝 건너뛰기
                    curTime = opEnd;
            }
        }
        
        if(curTime > vLength) // 영상 길이 초과
            curTime = vLength;
        else if(curTime < 0) // 시간 -일때
            curTime = 0;
        
        return intToPos(curTime);
    }
}