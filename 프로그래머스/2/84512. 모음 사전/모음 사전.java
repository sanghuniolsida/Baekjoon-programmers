import java.util.*;
class Solution {
    static String[] arr = new String[] {"A","E","I","O","U"};
    ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        dfs(0, "");
        Collections.sort(list);
        
        return list.indexOf(word)+1;
        
    }
    public void dfs(int index, String str) {
        if(index >= 5) { return; }
        for(int i=0;i<5;i++) {
            list.add(str+arr[i]);
            dfs(index+1, str+arr[i]);
        }
    }
}