class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: ArrayList<String> = ArrayList()
        //이름이 불리면 앞사람과 자리 바뀜
        //이름, 등수
        //등수, 이름
        //이름으로 등수(n)를 찾고 , 등수로 앞사람(n-1)을 찾음
        //이름, 등수를 수정
        //등수, 이름을 수정
        val nameToRank:HashMap<String,Int> = HashMap()
        val rankToName:HashMap<Int,String> = HashMap()
        for(i in 0 until players.size){
            val name = players[i]
            nameToRank.put(name,i)
            rankToName.put(i,name)
        }
        for (s in callings) {
            val rank = nameToRank[s] ?: continue
            var target = rankToName.get(rank-1) ?: continue
            nameToRank.put(target,rank)
            nameToRank.put(s,rank-1)
            rankToName.put(rank-1,s)
            rankToName.put(rank,target)
        }
        for(i in 0 until players.size){
            answer.add(rankToName.get(i).toString())
        }

        return answer.toTypedArray()
    }
}