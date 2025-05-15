class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] target = convert(n, k).split("0");
        for (String s : target) {
            if(s.equals(""))
                continue;
            long t = Long.parseLong(s);
            if (isPrime(t))
                answer++;
        }
        return answer;
    }

    public String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long n) {
        if (n == 1) 
            return false;
        if (n == 2) 
            return true;
        if (n % 2 == 0) 
            return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
}
