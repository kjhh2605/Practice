import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int len = truck_weights.length;
        Stack<Integer> wait = new Stack<>();
        int sum = 0;
        for(int i = len - 1 ; i >= 0 ; i--){
            wait.push(truck_weights[i]);
            sum+=truck_weights[i];
        }
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        while(bridge_length-- > 0){
            bridge.add(0);
        }
        int curW = 0 ; 
        int curSum = 0;
        while(curSum!=sum){
            int arrive = bridge.poll();
            curW -= arrive;
            curSum += arrive;
            
            if(!wait.isEmpty() && curW+wait.peek() <= weight){
                bridge.add(wait.pop());
                curW += bridge.peekLast();
            }
            else
                bridge.add(0);
            
            answer++;      
        }
            
        
        return answer;
    }
}