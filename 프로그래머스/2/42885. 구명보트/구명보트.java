import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int first = 0;
        int last = people.length - 1;
        int cnt = 0;
        while(true){
            int a = people[first];
            int b = people[last];
            if(a+b>limit){
                last--;
                answer++;
                cnt++;
            }else{
                first++;
                last--;
                answer++;
                cnt+=2;
            }
            if(first==last){
                answer++;
                break;
            }
            
            if(cnt==people.length)
                break;
        }

        return answer;
    }
}