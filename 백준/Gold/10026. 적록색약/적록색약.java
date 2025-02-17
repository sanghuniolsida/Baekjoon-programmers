import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;
    static boolean[][] check2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        check = new boolean[N][N];
        check2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int result1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    bfs(i, j, arr[i][j], check, false);
                    result1++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        int result2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check2[i][j]) {
                    bfs(i, j, arr[i][j], check2, true);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    public static void bfs(int x, int y, char color, boolean[][] visited, boolean isColorBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int n1 = now[0];
            int n2 = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = n1 + dx[i];
                int ny = n2 + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny] && arr[nx][ny] == color) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}