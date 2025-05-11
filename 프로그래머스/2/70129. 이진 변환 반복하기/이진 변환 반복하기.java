class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        while(!s.equals("1")) {
            char[] string = s.toCharArray();
            for (char c : string) {
                if (c != '0')
                    sb.append(c);
                else {
                    answer[1]++;
                }
            }
            s = Integer.toBinaryString(sb.length());
            sb.setLength(0);
            answer[0]++;
        }

        return answer;
    }
}