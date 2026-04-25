import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        int cnt = map.size();
        int answer = nums.length / 2;
        
        return Math.min(cnt, answer);
    }
}