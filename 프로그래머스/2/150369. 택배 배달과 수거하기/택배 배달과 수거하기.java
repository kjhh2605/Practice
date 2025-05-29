import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        PriorityQueue<Integer> dPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) 
                dPQ.add(i);
            if (pickups[i] > 0) 
                pPQ.add(i);
        }

        while (!dPQ.isEmpty() || !pPQ.isEmpty()) {
            int dCap = cap;
            int pCap = cap;

            int a = 0;
            int b = 0;
            if (!dPQ.isEmpty()) 
                a = dPQ.peek();
            if (!pPQ.isEmpty()) 
                b = pPQ.peek();
            int dest = Math.max(a, b);

            // 배달
            while (!dPQ.isEmpty() && dCap > 0) {
                int idx = dPQ.peek();
                if (deliveries[idx] <= dCap) {
                    dCap -= deliveries[idx];
                    deliveries[idx] = 0;
                    dPQ.poll(); 
                } else {
                    deliveries[idx] -= dCap;
                    break;
                }
            }

            // 수거
            while (!pPQ.isEmpty() && pCap > 0) {
                int idx = pPQ.peek();
                if (pickups[idx] <= pCap) {
                    pCap -= pickups[idx];
                    pickups[idx] = 0;
                    pPQ.poll(); 
                } else {
                    pickups[idx] -= pCap;
                    break;
                }
            }

            answer += (dest + 1) * 2L; 
        }

        return answer;
    }
}
