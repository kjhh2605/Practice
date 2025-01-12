import java.util.*;

class Solution {
    public int check(int[] answer, int[] answers){
        int myAnswer = 0;
        int cnt = 0;
        for(int i = 0 ; i < answers.length ; i++){
            if(myAnswer > answer.length - 1)
                myAnswer = 0;
            if(answer[myAnswer] == answers[i]) // 맞았으면
                cnt++;
            myAnswer++;
        }
        return cnt;
    }
    public int[] solution(int[] answers) {
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
        int a = check(answer1, answers);
        int b = check(answer2, answers);
        int c = check(answer3, answers);
        
        int best = a;
        if(b > best)
            best = b;
        if(c > best)
            best = c;
        
        Vector<Integer> v = new Vector();
        if(a == best)
            v.add(1);
        if(b == best)
            v.add(2);
        if(c == best)
            v.add(3);
        
        int[] answer = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            answer[i] = v.get(i);
        }
        
        return answer;
    }
}