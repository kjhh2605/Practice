import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String h1 = getHead(a);
                String h2 = getHead(b);
                if (h1.compareTo(h2) == 0) {
                    Integer n1 = getNum(a);  
                    Integer n2 = getNum(b); 
                    return n1.compareTo(n2);  
                } else {
                    return h1.compareTo(h2);
                }
            }
        });
        return files;
    }

    public String getHead(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                end = i;
                break;
            }
        }
        if (end == 0) {
            return s.toUpperCase();
        }

        return s.substring(start, end).toUpperCase();
    }

    public Integer getNum(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = 0;
        boolean flag = false;

        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                if (!flag) {
                    flag = true;
                    start = i; 
                }
            }
            if (flag && !(c[i] >= '0' && c[i] <= '9')) {
                end = i; 
                break;
            }
        }

        if (end == 0) {
            end = s.length();
        }

        return Integer.parseInt(s.substring(start, end));
    }
}
