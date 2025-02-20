import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[] result = {-1, -1};
        int h = (n % w == 0) ? (n / w) : (n / w + 1);

        int[][] arr = new int[h][w];
        int indx = 1;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (indx <= n) {
                    arr[i][j] = indx;
                } else {
                    arr[i][j] = Integer.MAX_VALUE; 
                }
                indx++;
            }
        }

        for (int i = 1; i < h; i += 2) {
            int left = 0, right = w - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
        
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                if (arr[i][j] == num) {
                        result[0] = i;
                        result[1] = j;
                    }
            }
        }

        for (int i = result[0]; i < h; i++) {
            if (arr[i][result[1]] <= n) { 
                answer++;
            }
        }
        return answer;
    }
}
