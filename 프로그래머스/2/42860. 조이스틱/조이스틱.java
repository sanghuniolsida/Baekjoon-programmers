import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int code = 65;

        for (int i = 1; i <= 26; i++) {
            char ch = (char) code;
            map.put(ch, i);
            code++;
        }

        int len = name.length();

        // 기본 커서 이동: 오른쪽으로 쭉 가는 경우
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int k = map.get(c);

            // 알파벳 위/아래 이동
            int a = k - 1;
            int b = 27 - k;
            answer += Math.min(a, b);

            // i 다음부터 연속된 A 구간 찾기
            int next = i + 1;

            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 갔다가 다시 왼쪽으로 돌아가는 경우
            move = Math.min(move, i * 2 + len - next);

            // 왼쪽으로 먼저 갔다가 오른쪽으로 돌아오는 경우
            move = Math.min(move, (len - next) * 2 + i);
        }

        answer += move;

        return answer;
    }
}