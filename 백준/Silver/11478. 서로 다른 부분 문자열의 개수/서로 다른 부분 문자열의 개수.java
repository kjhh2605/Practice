import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        ArrayList<String> a = new ArrayList<>();
        for(int i = 1 ; i <= line.length() ; i++){ // 문자열 길이
            for(int j = 0 ; j+i <= line.length() ; j++){ // 문자열
                String s = line.substring(j,j+i);
                a.add(s);
            }
        }
        HashSet<String>hSet = new HashSet<>(a);
        System.out.println(hSet.size());
    }
}
