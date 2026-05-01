import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<plays.length;i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        int cnt = map.size();
        
        for(int i=0;i<cnt;i++) {
            String maxKey = "";
            int maxValue = Integer.MIN_VALUE;
            for(String key : map.keySet()) {
                if(maxValue < map.get(key)) {
                    maxKey = key;
                    maxValue = map.get(key);
                }
            }
            
            int firstIndex = -1;
            int secondIndex = -1;
            int firstPlay = -1;
            int secondPlay = -1;

            for (int j = 0; j < genres.length; j++) {
                if (maxKey.equals(genres[j])) {

                    if (plays[j] > firstPlay) {
                        secondPlay = firstPlay;
                        secondIndex = firstIndex;

                        firstPlay = plays[j];
                        firstIndex = j;
                    } else if (plays[j] > secondPlay) {
                        secondPlay = plays[j];
                        secondIndex = j;
                    }
                }
            }
            list.add(firstIndex);

            if (secondIndex != -1) {
                list.add(secondIndex);
            }

            map.remove(maxKey);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}


/*
1. 가장 많이 재생된 장르 먼저 수록
2. 장르 내에서 많이 재생된 노래 먼저 수록
3. 장르 내에서 재생 횟수가 같으면 고유 번호가 낮은 번호를 먼저 수록

*/