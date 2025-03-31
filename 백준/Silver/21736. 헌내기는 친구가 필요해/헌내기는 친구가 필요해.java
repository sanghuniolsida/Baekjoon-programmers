import java.util.*;
import java.io.*;

public class Main {
    static int N, M, cnt;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        arr = new char[N][M];
        visited = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] == 'X') {
                    visited[i][j] = true;
                }
                if (arr[i][j] == 'I') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        bfs(q); // BFS 실행
        System.out.println(cnt == 0 ? "TT" : cnt);
    }
    public static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0], y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if ((arr[nx][ny] == 'O' || arr[nx][ny] == 'P') && !visited[nx][ny]) {
                    if (arr[nx][ny] == 'P') cnt++;
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
