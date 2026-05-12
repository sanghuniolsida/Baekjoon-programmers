import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int newcoke = (n / a) * b;
            answer += newcoke;
            
            n = newcoke + (n % a);
        }
        
        return answer;
    }
}