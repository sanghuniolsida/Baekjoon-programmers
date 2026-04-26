import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            q.add(ch);
        }
         
        int cnt = 0;
        if(q.peek() == ')') {
            return false;
        } else {
            while(!q.isEmpty()) {
            char c = q.poll();
            if(c == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if(cnt < 0) {
                return false;
            }    
        }
        }
        if(cnt > 0){
            return false;
        } 
        return true;
    }
}