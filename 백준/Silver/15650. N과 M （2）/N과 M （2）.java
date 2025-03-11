import jdk.jshell.execution.JdiExecutionControlProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int[] array;
    static ArrayList<int[]> list;

    public static void search(int depth,int n, int m , int tmp){
        if(depth == m){
            for(int i = 1; i < array.length ; i++){
                if(array[i-1] >= array[i])
                    return;
            }
            list.add(array.clone());
            return;
        }
        for(int i = tmp ; i <= n ; i++){// 1~n까지 길이m 배열의 각 인덱스에 넣어봄
            array[depth] = i;
            search(depth+1,n,m,tmp+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        array = new int[m];
        list = new ArrayList<>();

        search(0,n,m,1);
        for (int[] ints : list) {
            for (int a : ints) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
