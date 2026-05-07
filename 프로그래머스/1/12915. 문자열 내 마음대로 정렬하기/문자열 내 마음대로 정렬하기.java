import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings.length - 1 - i; j++) {
                String s1 = strings[j];
                char ch1 = s1.charAt(n);
                
                String s2 = strings[j + 1];
                char ch2 = s2.charAt(n);
                
                if (ch1 > ch2) {
                    strings[j] = s2;
                    strings[j + 1] = s1;
                }
            }
        }
        
        return strings;
    }
}