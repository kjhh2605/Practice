import java.util.*

class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 0
        val line = Array(w + 1) { Stack<Int>() }
        var index:Int = 1
        var flag:Boolean = true
        var check = 0
        for(i in 1..n){
            line[index].push(i)
            if(i==num)
                check=index
            if(flag){
                index++
                if(index>w) {
                    flag = false
                    index--
                }
            }else{
                index--
                if(index < 1){
                    flag = true
                    index++
                }
            }
        }
        while(!line[check].isEmpty()){
            if(line[check].pop() != num)answer++
            else break
        }

        return answer+1
    }
}