class Solution {
    public int solution(int n) {
        int answer = 0;
        // n<=60000
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int a = 1;
        int b = 2;
        for(int i = 3 ; i <= n ; i++){
            answer=(a+b)%1000000007;
            a=b;
            b=answer;
        }
        
        return answer;
    }
}