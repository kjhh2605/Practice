import java.util.*;

class Solution {
    private int m = -1;
    private int jinbub = -1;
    public String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        
        // 수식에 있는 한자리 수 중 최댓값이 m일때 -> m+1~9진법
        // X를 십진법으로 계산해서 m보다 작으면 그 값으로 확정
        List<int[]> target = new ArrayList<>();
        
        for(int i = 0 ; i < expressions.length ; i++){
            int[] tmp = new int[4];
            String ex = expressions[i];
            String[] s = ex.split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[2]);
            tmp[0] = a;
            tmp[1] = b;
            
            if(s[1].equals("+")){
                tmp[3] = 1;
            }else{
                tmp[3] = -1;
            }
            
            
            int c = -1;
            // 결과 지워진게 아니면
            if(!s[4].equals("X")){
                c = Integer.parseInt(s[4]);
                tmp[2] = c;
                checkM(a,b,c);
            }else{
                tmp[2] = -1;
                checkM(a,b,-1);
                target.add(tmp);
                continue;
            }
            
            findJinBub(tmp);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < target.size() ; i++){
            int[] e = target.get(i);
            int a = e[0];
            int b = e[1];
            int sign = e[3];
            
            if(jinbub!=-1){
                int c = (convertNum(a,jinbub)+convertNum(b,jinbub)*sign)/jinbub*10+(convertNum(a,jinbub)+convertNum(b,jinbub)*sign)%jinbub;
                sb.append(a).append(" ").append(sign==1?"+":"-").append(" ").append(b).append(" =").append(" ").append(a+b*sign);
            }else{
                if( a<m && b<m && (a+b*sign) < m ){
                    sb.append(a).append(" ").append(sign==1?"+":"-").append(" ").append(b).append(" =").append(" ").append(a+b*sign);
                }else{
                    sb.append(a).append(" ").append(sign==1?"+":"-").append(" ").append(b).append(" =").append(" ").append("?");
                }
            }
            answer.add(sb.toString());
            sb.setLength(0);
        }
        
        return answer.toArray(String[]::new);
    }
    
    private void checkM(int a, int b, int c){
        if(a < 9){
            m = Math.max(m,a);
        }
        if(b < 9){
            m = Math.max(m,b);
        }
        if(c < 9){
            m = Math.max(m,c);
        }
    }
    
    private void findJinBub(int[] tmp){
        for(int i = m ; i <= 9 ; i++){
            int a = tmp[0];
            int b = tmp[1];
            int c = tmp[2];
            int sign = tmp[3];
            
            if(convertNum(a,i)+convertNum(b,i)*sign == convertNum(c,i)){
                jinbub = i;
            }
        }
    }
    
    private int convertNum(int a, int i){
        return a/10*i+a%10;
    }
}
