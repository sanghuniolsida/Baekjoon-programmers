import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> q = new Stack<>();
        while (n > 0) {
            q.push(n % 3); 
            n /= 3;
        }
        int multi = 1;
        while (!q.isEmpty()) {
            int x = q.pop(); 
            answer += x * multi; 
            multi *= 3; 
        }
        return answer;
    }
}
