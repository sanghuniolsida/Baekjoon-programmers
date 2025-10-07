import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;
        
        for(int i=n-1;i>=0;i--) {
            deliver += deliveries[i];
            pickup += pickups[i];
            
            while(deliver > 0 || pickup > 0) {
                deliver -= cap;
                pickup -= cap;
                answer += (i+1)*2;
            }
        }
        
        
        
        
        
        return answer;
    }
}


/*
1. 일렬로 나열된 n개의 집에 택배 배달하는 문제
2. 배달을 다니면서 빈 상자들 수거
3. i번째 집은 i만큼 떨어져 있음
4. i~j의 거리는 j-i
5. 트럭에는 최대 cap개의 상자를 실을 수 있음.
6. 최소 이동거리 구하기
*/