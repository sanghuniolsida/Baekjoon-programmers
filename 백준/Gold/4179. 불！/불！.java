import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static int[][] fireDist, jihoonDist;
    static Queue<int[]> fireQ = new LinkedList<>();
    static Queue<int[]> jihoonQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        fireDist = new int[R][C];
        jihoonDist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihoonDist[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'J') {
                    jihoonQ.offer(new int[]{i, j});
                    jihoonDist[i][j] = 0;
                } else if (arr[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
            }
        }

        spreadFire();
        int result = escapeJihoon();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    public static void spreadFire() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (arr[nx][ny] == '#' || fireDist[nx][ny] != -1) continue;

                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }
    }

    public static int escapeJihoon() {
        while (!jihoonQ.isEmpty()) {
            int[] cur = jihoonQ.poll();
            int x = cur[0], y = cur[1];

            if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                return jihoonDist[x][y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (arr[nx][ny] == '#' || jihoonDist[nx][ny] != -1) continue;

                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihoonDist[x][y] + 1) continue;

                jihoonDist[nx][ny] = jihoonDist[x][y] + 1;
                jihoonQ.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}
