import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        String answer = "";
        for(String str1 : participant) {
            map.put(str1,map.getOrDefault(str1, 0) + 1);
        }
        
        for(String str2 : completion) {
            map.put(str2,map.get(str2) - 1);
        }
        
        for(String str : map.keySet()){
            if(map.get(str) != 0) {
                answer = str;
            }
        }
        return answer;
    }
}

/*
참여 선수: participant
완주 선수: completion



*/