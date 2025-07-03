import java.io.*;
import java.util.*;

public class Main {
    static int[] board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[101];
        visited = new boolean[101];

        int[][] arr = new int[10][2];
        for(int i=0;i<N+M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a] = b;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0}); // 처음에 들어갈 값은 시작 위치와 카운트
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == 100) {
                System.out.println(y);
                break;
            }

            for(int i=1;i<=6;i++) {
                int next = x + i;
                if(next > 100) continue;

                if(board[next] != 0) {
                    next = board[next];
                }

                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, y+1});
                }
            }
        }
    }
}