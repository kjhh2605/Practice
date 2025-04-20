import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        // 빵1, 야채2, 고기3 빵1
        var s: Stack<Int> = Stack<Int>()
        for(i in 0 until ingredient.size){
            s.push(ingredient[i])
            if(s.size < 4)
                continue
            if(s[s.size-1]==1&&s[s.size-2]==3&&s[s.size-3]==2&&s[s.size-4]==1){
                repeat(4){s.pop()}
                answer++
            }
        }
        
        return answer
    }
}