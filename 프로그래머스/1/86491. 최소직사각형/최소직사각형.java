import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0;i<sizes.length;i++) {
            for(int j=0;j<2;j++) {
                if(sizes[i][0] < sizes[i][1]) {
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
            }
        }
        int X = 0;
        int Y = 0;
        for(int i=0;i<sizes.length;i++) {
            if(sizes[i][0] > X) {
                X = sizes[i][0];
            }
        }
        for(int i=0;i<sizes.length;i++) {
            if(sizes[i][1] > Y) {
                Y = sizes[i][1];
            }
        }
        answer = X * Y;
        return answer;
    }
}