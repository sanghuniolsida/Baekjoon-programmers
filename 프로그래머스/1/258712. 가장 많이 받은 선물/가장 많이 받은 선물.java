import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] arr = new int[n][n];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(friends[i], i);

        for (String g : gifts) {
            String[] s = g.split(" ");
            if (s.length != 2 || !map.containsKey(s[0]) || !map.containsKey(s[1])) {
                continue;
            }
            int x = map.get(s[0]);
            int y = map.get(s[1]);
            if (x != y) arr[x][y]++;
        }

        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int give = 0, take = 0;
            for (int j = 0; j < n; j++) {
                give += arr[i][j];
                take += arr[j][i];
            }
            giftIndex[i] = give - take;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][j] > arr[j][i]) {
                    result[i]++;
                } else if (arr[i][j] < arr[j][i]) {
                    result[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        result[i]++; 
                    } else if (giftIndex[i] < giftIndex[j]) {
                        result[j]++; 
                    }
                }
            }
        }

        int answer = 0;
        for (int v : result) answer = Math.max(answer, v);
        
        return answer;
    }
}