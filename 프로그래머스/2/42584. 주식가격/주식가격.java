import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length-1;i++) {
            int sec = 0;
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i] <= prices[j]) {
                    sec++;
                }
                if(prices[i] > prices[j]) {
                    sec++;
                    break;
                }
            }
            answer[i] = sec;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}

/*
-인덱스 번호가 지나간 sec라고 생각하면 될 것 같아.
*/