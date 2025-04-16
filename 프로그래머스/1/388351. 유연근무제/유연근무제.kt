class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0
        for(i in 0 until timelogs.size){
            val standard = schedules[i]
            var end = if(standard%100>=50)standard+110-standard%100-60+standard%100 else standard+10
            var day = startday
            var flag = true
            for(j in 0..timelogs[i].size-1){
                val cur = timelogs[i][j]
                if(day!=6 && day!=7){
                    if(cur>end) {
                        flag = false
                        break;
                    }
                }
                day = if(++day>7) 1 else day
            }
            if(flag)
                answer++
        }
        
        return answer
    }
}