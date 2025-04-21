class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val r = park.size
        val c = park[0].length
        val map = Array(r) { Array(c){""} }

        var curX = 0
        var curY = 0

        for (i in 0 until r) {
            val row = park[i].split("")
            for (j in 1..c) {  
                map[i][j - 1] = row[j]
                if (row[j] == "S") {
                    curX = j - 1
                    curY = i
                }
            }
        }

        for (i in routes.indices) {
            val (command, dStr) = routes[i].split(" ")
            val d = dStr.toInt()

            when (command) {
                "E" -> {
                    var flag = true
                    for (j in 1..d) {
                        if (curX + j >= c || map[curY][curX + j] == "X") {
                            flag = false
                            break
                        }
                    }
                    if (flag) curX += d
                }

                "W" -> {
                    var flag = true
                    for (j in 1..d) {
                        if (curX - j < 0 || map[curY][curX - j] == "X") {
                            flag = false
                            break
                        }
                    }
                    if (flag) curX -= d
                }

                "S" -> {
                    var flag = true
                    for (j in 1..d) {
                        if (curY + j >= r || map[curY + j][curX] == "X") {
                            flag = false
                            break
                        }
                    }
                    if (flag) curY += d
                }

                "N" -> {
                    var flag = true
                    for (j in 1..d) {
                        if (curY - j < 0 || map[curY - j][curX] == "X") {
                            flag = false
                            break
                        }
                    }
                    if (flag) curY -= d
                }
            }
        }

        return intArrayOf(curY, curX)
    }
}
