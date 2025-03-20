class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        for(double i : numbers){
            sum += i;
        }
        answer = sum/numbers.length;
        return answer;
    }
}