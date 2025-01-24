import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int answer = Integer.MIN_VALUE;
        int n = sc.nextInt();
        int[]array = new int[n];
        for(int i = 0 ; i < n ; i++){
            array[i] = sc.nextInt();
        }

        boolean flag = true;
        for (int i : array) { // 배열 전체가 음수인지 확인
            if(i > answer)
                answer = i;
            if(i > 0) {
                flag = false;
                break;
            }
        }
        if(flag){ // 전체 음수이면
            System.out.println(answer); // answer = 가장 큰 원소
            return; // 종료
        }

        answer = Integer.MIN_VALUE; // 통과했으면 값 초기화
        int start = 0;
        int cur = 0;
        for( int end = 0 ; end < n ; end++){
            cur += array[end]; // end 까지
            while(cur < answer && start <= end){ //값이 기존 값 보다 작을 때
                if(cur < 0 && array[end] < 0 ){ // 음수를 만나서 0보다 작아지면
                    start = end+1; // 새로운 시작점을 다음 원소의 인덱스로 설정
                    cur = 0; // 새로 비교 시작
                    break;
                }
                if(cur > 0 && array[end] < 0 ) // 음수를 만나도 0보다 크면 이후 커질 수 있음
                    break;
                if(cur - array[start] > cur) {
                    cur -= array[start]; // 음수를 만나지 않는 경우
                    start++;
                }else{
                    break;
                }
            }
            if(start < n && array[start] < 0){
                cur -= array[start];
                start++;
            }

            if(cur > answer) // 큰 부분합을 찾으면 교체
                answer = cur;
        }

        System.out.println(answer);
    }
}
