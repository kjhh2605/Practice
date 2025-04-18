import javax.swing.text.html.HTML.Attribute.N

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var result = Array<Int>(4){0}
        for(i in 0 until survey.size){
            val s = survey[i][0]
            when(s){
                'R'->{
                    if(choices[i] > 4)
                        result[0]+=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[0]-=(4-choices[i])
                    println(result[0])
                }
                'T'->{
                    if(choices[i] > 4)
                        result[0]-=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[0]+=(4-choices[i])
                    println(result[0])
                }
                'C'->{
                    if(choices[i] > 4)
                        result[1]+=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[1]-=(4-choices[i])
                }
                'F'->{
                    if(choices[i] > 4)
                        result[1]-=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[1]+=(4-choices[i])
                }'J'->{
                if(choices[i] > 4)
                    result[2]+=(choices[i]-4)
                else if(choices[i] < 4)
                    result[2]-=(4-choices[i])
            }
                'M'->{
                    if(choices[i] > 4)
                        result[2]-=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[2]+=(4-choices[i])
                }
                'A'->{
                    if(choices[i] > 4)
                        result[3]+=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[3]-=(4-choices[i])
                }
                'N'->{
                    if(choices[i] > 4)
                        result[3]-=(choices[i]-4)
                    else if(choices[i] < 4)
                        result[3]+=(4-choices[i])
                }

            }
        }
        answer+=if(result[0]<=0)"R" else "T"
        answer+=if(result[1]<=0)"C" else "F"
        answer+=if(result[2]<=0)"J" else "M"
        answer+=if(result[3]<=0)"A" else "N"
        return answer
    }
}