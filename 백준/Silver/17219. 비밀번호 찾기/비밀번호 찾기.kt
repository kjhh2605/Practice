package com.example.myapplication

fun main(){
    val sb = StringBuilder()
    val (n,m) = readln().split(" ").map { it.toInt() }
    val h = HashMap<String,String>()
    for(i in 1..n){
        val(site,pw) = readln().split(" ")
        h.put(site,pw)
    }
    for(i in 1..m){
        sb.append(h.get(readln())).append("\n")
    }
    println(sb)
}
