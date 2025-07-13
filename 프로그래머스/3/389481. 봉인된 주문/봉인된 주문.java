import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class Solution {
    public String solution(long n, String[] bans) {
        ArrayList<Long> banToLong = new ArrayList<>();
        for(String b : bans){
            char[] spell = b.toCharArray();
            long num = 0;
            for(int i = 0 ; i < spell.length; i++){
                long k = spell.length-i-1;
                long t = 1;
                while(k-->0){
                    t *= 26;
                }
                num += (spell[i] - 'a' + 1) * t;
            }
            banToLong.add(num);
        }
        banToLong.sort(null);
        while(!banToLong.isEmpty() && banToLong.get(0)<=n){
            int cnt = 0;
            Iterator<Long> it = banToLong.iterator();
            while(it.hasNext()){
                Long l  = it.next();
                if(l<=n){
                    cnt++;
                    it.remove();
                }else
                    break;
            }
            n+=cnt;
        }

        
        StringBuilder sb = new StringBuilder();
        n--; 

        while (n >= 0) {
            sb.append((char) ('a' + (n % 26)));
            n = n / 26 - 1; 
        }

        return sb.reverse().toString();
    }
}