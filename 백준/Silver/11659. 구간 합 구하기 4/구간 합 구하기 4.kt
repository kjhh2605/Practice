package com.example.myapplication

fun main(){
    val sb = StringBuilder()
    var (n,m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map{it.toInt()}
    val sums = IntArray(n,{0}) // 크기 n , 원소 0으로 초기화
    var sum = 0
    for(i in 0 until nums.size){
        sum += nums[i]
        sums[i] = sum
    }
    while(m-- > 0){
        val(a,b) = readln().split(" ").map{it.toInt()}
        sb.append(sums[b-1]-sums[a-1]+nums[a-1]).append("\n")
    }
    println(sb)
}
