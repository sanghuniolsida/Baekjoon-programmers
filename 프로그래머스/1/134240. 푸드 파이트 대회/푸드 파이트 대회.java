import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1;i<food.length;i++) {
            int cnt = food[i] / 2;
            String str = String.valueOf(i);
            for(int j=0;j<cnt;j++) {
                answer += str;
            }
        }
        
        StringBuilder sb = new StringBuilder(answer);
        String result = sb.reverse().toString();
        answer = answer + "0" + result;
        
        return answer;
    }
}