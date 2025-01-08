class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 1초에 x
        // t초 채우면 +y
        // 최대 체력
        // 공격 받으면 시간 0
        // 체력 0이하 종료
        int t = bandage[0]; // 시전시간  
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        int time = attacks[attacks.length-1][0]; // 마지막 공격 시간
        
        int curHealth = health;
        int attackCount = 0;
        int bandageCount = 0;
        
        for(int i = 0; i <= time ; i++){
           if(attacks[attackCount][0] == i){ // 공격 당하면
               bandageCount = 0; // 회복 초기화
               curHealth -= attacks[attackCount][1]; // 체력 감소
               if(curHealth <= 0)
                   return -1; // 종료
               attackCount++;
               System.out.println(curHealth);
               continue;
           }
            
            bandageCount++;
            
           if(curHealth < health){
               curHealth += x; // 1초 마다 증가
               if(bandageCount == t){
                   curHealth += y;
                   bandageCount = 0; // 초기화
               }
               if(curHealth > health) // 최대 체력이면 증가x
                   curHealth = health;
              
           }    
            
        }
        return curHealth;
        
        
    }
}