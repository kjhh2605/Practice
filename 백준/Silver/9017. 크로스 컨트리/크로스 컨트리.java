import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            T--;
            int best = Integer.MAX_VALUE;
            int answer = -1;

            int people = sc.nextInt();
            ArrayList<Integer> rank = new ArrayList<>(); // 들어온 순위
            ArrayList<Integer> team = new ArrayList<>(); // 참가 팀
            for(int i = 0 ; i < people ; i++) {
                int a = sc.nextInt();
                rank.add(a);

                if (!team.contains(a))
                    team.add(a);
            }
            ArrayList<Integer>notTarget = new ArrayList<>(); // 6명 미만 팀
            for (Integer i : team) {
                int cnt = 0;
                for(Integer j : rank){
                    if(i.equals(j))
                        cnt++;
                }
                if(cnt < 6)
                    notTarget.add(i);
            }
            for (Integer i : notTarget) { // 랭킹에서 6명 미만 팀 제거
                for(int j = 0 ; j < rank.size() ; j++){
                    if(rank.get(j).equals(i)) {
                        rank.remove(j);
                        j--;
                    }
                }
            }
            HashMap<Integer,Integer> h = new HashMap<>(); // <팀,점수>
            HashMap<Integer,Integer> cnt = new HashMap<>(); // <팀,누적 명수> -> 4명 확인
            for(int i = 0 ; i < rank.size() ; i++){
                if(h.containsKey(rank.get(i)) && cnt.get(rank.get(i)) < 4 ) {//&& cnt.get(rank.get(i)) < 5
                    h.replace(rank.get(i), h.get(rank.get(i)) + i + 1);
                    cnt.replace(rank.get(i),cnt.get(rank.get(i))+1);
                    //System.out.println("팀:"+rank.get(i) +" 점수" + h.get(rank.get(i)) +" 횟수: "+cnt.get(rank.get(i)) + " f");
                }else if(h.containsKey(rank.get(i))){
                    continue;
                }
                else {
                    h.put(rank.get(i), i + 1);
                    cnt.put(rank.get(i),1);
                    //System.out.println("팀:"+rank.get(i) +" 점수" + h.get(rank.get(i)) +" 횟수: "+cnt.get(rank.get(i))+" s");
                }
            }
//            for (Integer i : h.keySet()) {
//                //System.out.println("팀:" + i + " 점수:" + h.get(i) + "횟수:" +cnt.get(i)+" t");
//            }
            ArrayList<Integer> sameScore = new ArrayList<>();
            for (Integer i : team) {
                if(h.containsKey(i)){
                    if(best > h.get(i)){
                        best = h.get(i);
                        answer = i;
                        sameScore.clear(); // 더 작은 점수 나오면 동점 리스트 초기화
                        sameScore.add(i);
                    }else if(Integer.valueOf(best).equals(h.get(i))){
                        sameScore.add(i);
                    }
                }
            }
            if(!sameScore.isEmpty()){
                int fifth = Integer.MAX_VALUE;
                for (Integer i : sameScore) {
                    int count = 0;
                    for (int j = 0 ; j < rank.size() ; j++) {
                        if(rank.get(j).equals(i)) // 우승후보 팀 중에
                            count ++;
                        if(count == 5){ //5등을 찾아서
                            //System.out.println("팀:" + i +" / 5등: "+(j+1));
                            if(j+1 < fifth){
                                answer = i;
                                fifth = j+1;
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
