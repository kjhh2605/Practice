package com.example.myapplication
fun main(){
    var(a,b) = readln().split(" ").map { it.toInt() }
    var visitied = BooleanArray(200001){false}
    var pos = IntArray(200001){Integer.MAX_VALUE}
    var q = ArrayDeque<Int>()
    q.add(a)
    visitied[a] = true
    var time = 0
    loop@while(!q.isEmpty()){
        var s = q.size
        while(s-- > 0){
            val cur = q.removeFirst()
            if(cur == b)
                break@loop
            if(cur > b){ // 도착 위치 넘어갔으면
                if(!visitied[cur-1]){
                    visitied[cur-1] = true;
                    q.add(cur-1);
                }
                continue;
            }else{
                if(cur*2 < 200000 && !visitied[cur*2]){
                    visitied[cur*2] = true;
                    q.addFirst(cur*2);
                    s++
                }
                if(cur-1 > 0 && !visitied[cur-1]){
                    visitied[cur-1] = true;
                    q.add(cur-1);
                }
                if(!visitied[cur+1]){
                    visitied[cur+1] = true;
                    q.add(cur+1);
                }
            }
        }
        time++
    }
    println(time)
}

