import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];

            if (remain % speeds[i] == 0) {
                days[i] = remain / speeds[i];
            } else {
                days[i] = remain / speeds[i] + 1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        int current = days[0];
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[i] <= current) {
                count++;
            } else {
                list.add(count);
                current = days[i];
                count = 1;
            }
        }

        list.add(count);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}