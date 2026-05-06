import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int s = (int)Math.sqrt(sum);

        for (int h = 3; h <= s; h++) {
            if (sum % h == 0) {
                int w = sum / h;

                if ((w - 2) * (h - 2) == yellow) {
                    return new int[] {w, h};
                }
            }
        }

        return new int[] {};
    }
}