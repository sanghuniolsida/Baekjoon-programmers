import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static char[][] arr;
    static int[][] fireDist;
    static int[][] personDist;
    static boolean[][] fireVisited;
    static boolean[][] personVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            fireQueue = new LinkedList<>();
            q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[M][N];
            fireDist = new int[M][N];
            personDist = new int[M][N];
            fireVisited = new boolean[M][N];
            personVisited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j);
                    fireDist[i][j] = Integer.MAX_VALUE;
                    personDist[i][j] = -1;

                    if (arr[i][j] == '*') {
                        fireQueue.offer(new int[]{i, j});
                        fireVisited[i][j] = true;
                        fireDist[i][j] = 0;
                    }
                    if (arr[i][j] == '@') {
                        q.offer(new int[]{i, j});
                        personVisited[i][j] = true;
                        personDist[i][j] = 0;
                    }
                }
            }

            bfsFire();
            int result = bfsPerson();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    public static void bfsFire() {
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (!fireVisited[nx][ny] && arr[nx][ny] == '.') {
                    fireQueue.offer(new int[]{nx, ny});
                    fireDist[nx][ny] = fireDist[x][y] + 1;
                    fireVisited[nx][ny] = true;
                }
            }
        }
    }

    public static int bfsPerson() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || x == M - 1 || y == 0 || y == N - 1) {
                return personDist[x][y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (!personVisited[nx][ny] && arr[nx][ny] == '.') {
                    if (fireDist[nx][ny] > personDist[x][y] + 1) {
                        q.offer(new int[]{nx, ny});
                        personDist[nx][ny] = personDist[x][y] + 1;
                        personVisited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
