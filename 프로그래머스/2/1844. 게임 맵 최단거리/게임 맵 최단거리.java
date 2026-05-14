import java.util.*;
class Solution {
    static boolean[][] check;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> q;
    public int solution(int[][] maps) {
        int col = maps.length;
        int row = maps[0].length;
        int answer = 0;
        check = new boolean[col][row];
        
        q = new LinkedList<>();
        q.offer(new int[] {0,0});
        check[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int c1 = cur[0];
            int c2 = cur[1];
            
            for(int i=0;i<4;i++) {
                int x = dx[i] + c1;
                int y = dy[i] + c2;
                if(x >= col || y >= row || x < 0 || y < 0) {
                    continue;
                }
                
                if(maps[x][y] == 1 && !check[x][y]) {
                    q.offer(new int[] {x,y});
                    check[x][y] = true;
                    maps[x][y] = maps[c1][c2] + 1;
                }
            }
        }
        if(maps[col-1][row-1] == 1) {
            answer = -1;
        } else {
            answer = maps[col-1][row-1];
        }
        
        return answer;
    }
}