import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {

        Integer[] a =  new Integer[citations.length];
        for(int i = 0; i < citations.length; i++){
            a[i] = citations[i];
        }
        Arrays.sort(a, Collections.reverseOrder());
        for(int i = 0; i < citations.length; i++){
            if (a[i] < i + 1) {
                return i;
            }
        }
        return citations.length;
    }
}