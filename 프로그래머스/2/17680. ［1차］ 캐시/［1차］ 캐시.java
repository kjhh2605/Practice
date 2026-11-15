import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int n = cities.length;
        
        for(int i = 0 ; i < n ; i++){
            cities[i] = cities[i].toLowerCase();
        }
        
        Queue<String> cashTable = new ArrayDeque<>();
        for(String city : cities){
            if(cashTable.contains(city)){
                answer++;
                
                Queue<String> tmp = new ArrayDeque<>();
                while(!cashTable.isEmpty()){
                    String s = cashTable.poll();
                    if(!s.equals(city)){
                        tmp.add(s);
                    }
                }
                tmp.add(city);
                if(cashTable.size()>cacheSize){
                    cashTable.poll();
                }
                cashTable = tmp;
            }else{
                answer+=5;
                cashTable.add(city);
                if(cashTable.size()>cacheSize){
                    cashTable.poll();
                }
            }
        }
        
        
        return answer;
    }
}