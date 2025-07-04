import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer, cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Stack<int[]> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dfs 알고리즘을 사용해서 최대값을 구하면 되는거 같아.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 1;

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;

                checkExtraShape(i, j);
            }
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void checkExtraShape(int x, int y) {
        int[][] shapes = {
                {0, 1, 0, -1, 1, 0},   // ㅗ
                {0, 1, -1, 0, 1, 0},   // ㅏ
                {0, 1, 0, -1, -1, 0},  // ㅜ
                {0, -1, -1, 0, 1, 0}   // ㅓ
        };

        for (int[] shape : shapes) {
            try {
                int total = arr[x][y]
                        + arr[x + shape[0]][y + shape[1]]
                        + arr[x + shape[2]][y + shape[3]]
                        + arr[x + shape[4]][y + shape[5]];
                answer = Math.max(answer, total);
            } catch (ArrayIndexOutOfBoundsException e) {
                // 도형이 범위 벗어나는 경우는 무시
            }
        }
    }
}