class Solution {
    fun solution(food: IntArray): String {
        var sb = StringBuilder()
        for(i in 1 until food.size){
            var f = food[i]/2
            for(j in 1..f){
                sb.append(i)
            }
        }
        var tmpString = sb.toString()
        sb.append(0).append(tmpString.reversed())
        return sb.toString()
    }
}