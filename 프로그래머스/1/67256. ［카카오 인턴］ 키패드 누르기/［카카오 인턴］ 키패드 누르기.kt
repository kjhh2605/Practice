import java.util.*;
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var left: IntArray = intArrayOf(0, 3)
        var right: IntArray = intArrayOf(2, 3)
        var pad = Array(10) { Array(2) { 0 } }
        pad[0][0] = 1
        pad[0][1] = 3
        var x = 0
        var y = 0
        for (i in 1..9) {
            pad[i][0] = x
            pad[i][1] = y
            x++
            if (x > 2) {
                x = 0
                y++
            }
        }
        for (i in 0 until numbers.size) {
            val n = numbers[i]
            when (n) {
                1, 4, 7 -> {
                    answer += "L"
                    left[0] = pad[n][0]
                    left[1] = pad[n][1]
                }

                3, 6, 9 -> {
                    answer += "R"
                    right[0] = pad[n][0]
                    right[1] = pad[n][1]
                }

                else -> {
                    var rCnt = Math.abs(pad[n][1] - right[1]) + Math.abs(pad[n][0] - right[0])
                    var lCnt = Math.abs(pad[n][0] - left[0]) + Math.abs(pad[n][1] - left[1])
                    if (rCnt > lCnt) {
                        answer += "L"
                        left[0] = pad[n][0]
                        left[1] = pad[n][1]
                    } else if (lCnt > rCnt) {
                        answer += "R"
                        right[0] = pad[n][0]
                        right[1] = pad[n][1]
                    } else {
                        if (hand.equals("right")) {
                            answer += "R"
                            right[0] = pad[n][0]
                            right[1] = pad[n][1]
                        } else {
                            answer += "L"
                            left[0] = pad[n][0]
                            left[1] = pad[n][1]
                        }
                    }
                }
            }
        }

        return answer
    }
}