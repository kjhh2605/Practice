import java.util.*;

class Solution {
    public int solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
            if (cur.equals("Z")) {
                if (!stack.isEmpty()) { 
                    sum -= stack.peek();
                }
            } else {
                int num = Integer.parseInt(cur);
                stack.push(num);
                sum += num;
            }
        }
        return sum;
    }
}
