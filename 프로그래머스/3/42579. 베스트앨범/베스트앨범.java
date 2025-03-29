import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genrePlays = new HashMap<>();
        HashMap<String, ArrayList<Integer>> idList = new HashMap<>();
        HashMap<Integer,Integer> playnum = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            String genre = genres[i];
            int play = plays[i];
            if(genrePlays.containsKey(genre)){
                genrePlays.replace(genre,genrePlays.get(genre)+play);
                idList.get(genre).add(i);
            }
            else{
                genrePlays.put(genre,play);
                idList.put(genre,new ArrayList<Integer>());
                idList.get(genre).add(i);
            }
            playnum.put(i,play);
        }
        List<Map.Entry<String, Integer>> sortedGenre = new ArrayList<>(genrePlays.entrySet());
        sortedGenre.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : sortedGenre) {
            String curGenre = entry.getKey();
            ArrayList<Integer> id = idList.get(curGenre);
            HashMap<Integer,Integer> curGenrePlays = new HashMap<>();
            for(int i = 0 ; i < id.size() ; i++){
                curGenrePlays.put(id.get(i),playnum.get(id.get(i)));
            }
            List<Map.Entry<Integer,Integer>> sortedId = new ArrayList<>(curGenrePlays.entrySet());
            sortedId.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            int cnt = 0;
            for(Map.Entry<Integer,Integer> e : sortedId){
                answer.add(e.getKey());
                cnt++;
                if(cnt==2)
                    break;
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}