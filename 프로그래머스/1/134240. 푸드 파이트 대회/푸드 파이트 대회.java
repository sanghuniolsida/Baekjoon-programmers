import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for(int i=1;i<food.length;i++) {
            int cnt = food[i] / 2;
            String str = String.valueOf(i);
            for(int j=0;j<cnt;j++) {
                answer += str;
                stack.push(str);
            }
        }
        
        answer += "0";
        while(!stack.isEmpty()) {
            String str2 = stack.pop();
            answer += str2;
        }
        return answer;
    }
}