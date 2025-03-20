import java.util.HashSet;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] cur = {5,5};
        HashSet<String> h = new HashSet<>();
        for(int i = 0 ; i < dirs.length() ; i++){
            char c = dirs.charAt(i);
            int startX = cur[0];
            int startY = cur[1];
            switch(c){
                case 'U':
                    cur[1]++; 
                    break;
                case 'D':
                    cur[1]--;
                    break;
                case 'R':
                    cur[0]++;
                    break;
                case 'L':
                    cur[0]--;
                    break;
            }
            if(cur[0] < 0 || cur[0] > 10 || cur[1] < 0 || cur[1] > 10){
                cur[0] = startX;
                cur[1] = startY;
                continue;
            }
                
            String s = startX + "," + startY + "," + cur[0] + "," + cur[1];
            h.add(s);
            s = cur[0] + "," + cur[1] + "," + startX + "," + startY;
            h.add(s);
        }
        answer = h.size()/2;
        return answer;
    }
}