import java.util.*;

class Solution {
    static boolean[][] electric;
    static boolean[] visited;
    static int count;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        electric = new boolean[n + 1][n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            
            electric[x][y] = true;
            electric[y][x] = true;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            // 전선 하나 끊기
            electric[a][b] = false;
            electric[b][a] = false;
            
            visited = new boolean[n + 1];
            count = 0;
            
            // a번 송전탑에서 연결된 송전탑 개수 세기
            dfs(a, n);
            
            int left = count;
            int right = n - count;
            
            answer = Math.min(answer, Math.abs(left - right));
            
            // 끊었던 전선 다시 연결
            electric[a][b] = true;
            electric[b][a] = true;
        }
        
        return answer;
    }
    
    public void dfs(int node, int n) {
        visited[node] = true;
        count++;
        
        for(int i = 1; i <= n; i++) {
            if(electric[node][i] == true && visited[i] == false) {
                dfs(i, n);
            }
        }
    }
}