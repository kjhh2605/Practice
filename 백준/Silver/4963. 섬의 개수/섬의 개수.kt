package com.example.myapplication

import java.util.Stack

var visited:Array<BooleanArray>? = null
val dx = intArrayOf(0, 0, 1, -1, 1, 1, -1, -1)
val dy = intArrayOf(1, -1, 0, 0, 1, -1, -1, 1)
fun main(){
    val sb = StringBuilder()
    while(true){
        val (w,h) = readln().split(" ").map { it.toInt() }

        if(w==0 && h==0)
            break;

        val map = Array<IntArray>(h){IntArray(w)};
        visited = Array(h){BooleanArray(w)}

        for(i in 0 until h){
            val row = readln().split(" ").map{it.toInt()}
            for(j in 0 until w){
                map[i][j] = row[j]
            }
        }
        var cnt = 0
        for(i in 0 until h){
            for(j in 0 until w){
                if(map[i][j] == 1 && !visited!![i][j]){ // visited!! : visted를 non-nullable로 타입 바꿈
                    dfs(map,i,j);
                    cnt++
                }
            }
        }
        sb.append(cnt).append("\n")
    }
    print(sb)
}

fun dfs(map: Array<IntArray>, startY:Int, startX:Int){
    val s = Stack<IntArray>()
    s.push(intArrayOf(startY,startX))
    visited!![startY][startX] = true

    while(!s.isEmpty()){
        var cur = s.pop()
        var x = cur[1]
        var y = cur[0]

        for(i in 0 until 8){
            val curX = x+dx[i]
            val curY = y+dy[i]

            if (curX < 0 || curY < 0 || curX >= map[0].size || curY >= map.size || visited!![curY][curX]) continue
            if (map[curY][curX] == 1) {
                s.push(intArrayOf(curY, curX))
                visited!![curY][curX] = true
            }
        }
    }

}