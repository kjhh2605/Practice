class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        
        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];  
            end++;
            
            while (sum > k && start <= end) {
                sum -= sequence[start];
                start++;
            }

            if (sum == k) {
                if (end - start + 1 < length ) {  // 짧은 부분 수열을 찾으면
                    length = end - start + 1;
                    answer[0] = start;
                    answer[1] = end - 1;
                }
            }
        }

        return answer;
    }
}