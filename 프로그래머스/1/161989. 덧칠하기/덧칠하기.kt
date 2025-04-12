class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0
        var paintedUntil = 0

        for (s in section) {
            if (s > paintedUntil) {
                paintedUntil = s + m - 1
                answer++
            }
        }
        return answer
    }
}
