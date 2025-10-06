import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;
        int answer = 0;
        int cacheHit = 0;
        int cacheMiss = 0;
        
        LinkedList<String> list = new LinkedList<>();
        for(String str : cities) {
            str = str.toLowerCase();
            if(list.contains(str)) {
                list.remove(str);
                list.add(str);
                cacheHit++;
            } else {                            
                if (list.size() == cacheSize) {
                    list.removeFirst();        
                }
                list.addLast(str);
                cacheMiss++;
            }
        }
        answer = cacheHit * 1 + cacheMiss * 5;
        
        return answer;
    }
}