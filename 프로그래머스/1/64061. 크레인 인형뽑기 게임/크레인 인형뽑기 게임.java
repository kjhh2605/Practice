import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
    int answer = 0;
    
    Vector<Stack<Integer>>line = new Vector();
    for(int i = 0 ; i < board.length ; i++){
        Stack<Integer> tmp = new Stack();
        line.add(tmp); // 라인별로 관리하기 위한 스택
    }
    
    for(int i = board.length - 1 ; i > -1 ; i-- ){ // 아래부터
        for(int j =  0 ; j < board.length ; j++ ){ // line별로 추가
            if(board[i][j] == 0)
                continue;
            line.get(j).push(board[i][j]);
        }
    }
    
    Stack<Integer> basket = new Stack(); // 바구니
        
    for(int i : moves){
        int move = i - 1; // 벡터 인덱스에 맞추고
        
        if(line.get(move).isEmpty()) // 비어있으면 넘어감
            continue;
            
        if(!basket.isEmpty() && basket.peek()!=line.get(move).peek()){ //비어있지 않고 서로 다르면
            basket.push(line.get(move).pop());//꺼내서 바구니에 추가
            continue;
        }
        if(!basket.isEmpty() && basket.peek() == line.get(move).peek()){ // 같으면 터트림
            line.get(move).pop();
            basket.pop();
            answer += 2;
            continue;
        }
        
        basket.push(line.get(move).pop());
    }
    
    return answer;
    }
}