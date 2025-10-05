import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        int len = board.length;
        for(int i=0;i<moves.length;i++) {
            int x = moves[i]-1;
            for(int j=0;j<len;j++) {
                if(board[j][x] > 0) {
                    int z = board[j][x];
                    board[j][x] = 0;
                    if(!st.isEmpty() && st.peek() == z) {
                        answer++;
                        st.pop();
                    } else {
                        st.push(z);
                    }
                    break;
                }
            }
        }
        
        return answer*2;
    }
}