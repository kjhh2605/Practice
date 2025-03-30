import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,HashSet<String>> report_id = new HashMap<>();
        HashMap<String,Integer>reportCnt = new HashMap<>();
        
        for(String s : id_list){
            reportCnt.put(s,0);
        }
        
        for(int i = 0 ; i < report.length ; i++){
            String[] line = report[i].split(" ");
            String id = line[0];
            String target = line[1];
            if(report_id.containsKey(id)){
                if(report_id.get(id).contains(target))
                    continue;
                else{
                    reportCnt.replace(target,reportCnt.get(target)+1);
                    report_id.get(id).add(target);
                }
            }else{
                report_id.put(id,new HashSet<String>());
                report_id.get(id).add(target);
                reportCnt.replace(target,reportCnt.get(target)+1);
            }  
        }
        ArrayList<String>paused = new ArrayList<>();
        for(String s : id_list){
            if(reportCnt.get(s) >= k){
                paused.add(s);
            }
        }

        for(int i = 0 ; i < id_list.length ; i++){
            if(!report_id.containsKey(id_list[i]))
                continue;
            HashSet<String> h = report_id.get(id_list[i]);
            int cnt = 0;
            for(int j = 0 ; j < paused.size() ; j++){
                if(h.contains(paused.get(j)))
                    cnt++;
            }
            answer[i]=cnt;
        }
    
        return answer;
    }
}