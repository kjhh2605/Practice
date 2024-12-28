class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String num = Integer.toString(x);
        String[]array = num.split("");
        int sum = 0;
        for(String a : array){
            sum += Integer.parseInt(a);
        }
        
        if(x%sum != 0)
            answer = false;
        
        return answer;
    }
}