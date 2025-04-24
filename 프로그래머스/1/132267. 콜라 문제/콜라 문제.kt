class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var bottle = n
        var answer = 0
        while (bottle >= a) {
            val newCoke = (bottle / a) * b     
            answer += newCoke
            bottle = (bottle % a) + newCoke    
        }

        return answer
    }
}
