import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[i] = N을 i번 사용해서 만들 수 있는 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N, NN, NNN ... 같은 수 먼저 넣기
        int concat = 0;
        for (int i = 1; i <= 8; i++) {
            concat = concat * 10 + N;
            dp.get(i).add(concat);
        }

        for (int i = 1; i <= 8; i++) {
            if (dp.get(i).contains(number)) return i;

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}
