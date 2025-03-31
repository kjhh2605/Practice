import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String,Integer>courseCnt = new HashMap<>();
        
        for(int i = 0 ; i < orders.length ; i++){
            char[] menu = orders[i].toCharArray();
            Arrays.sort(menu); // 주문을 오름차순 정렬 -중복 방지..?
            
            for(int c: course){
                if(menu.length < c) 
                    break;
                dfs(menu,c,0,"",courseCnt);
            }       
        }
        
        for(int cnt : course){
            int max = 0;
            for(String key : courseCnt.keySet()){
                if(key.length() == cnt){
                    max = Math.max(max,courseCnt.get(key));
                }
            }
            for (String key : courseCnt.keySet()) {
                if (key.length() == cnt && courseCnt.get(key) == max && max >= 2) 
                    answer.add(key);
            }
        }
        
        return answer.stream().sorted().toArray(String[]::new);
    }
    
    
     private void dfs(char[] menu, int length, int start, String curCourse, HashMap<String, Integer> courseCnt) {
        if (curCourse.length() == length) {
            courseCnt.put(curCourse, courseCnt.getOrDefault(curCourse, 0) + 1);
            return;
        }

        for (int i = start; i < menu.length; i++) {
            dfs(menu, length, i + 1, curCourse + menu[i], courseCnt);
        }
    }
}