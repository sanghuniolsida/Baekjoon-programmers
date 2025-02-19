import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][][] dist; // dist[x][y][wallBroken] => wallBroken: 0(안 부순), 1(부순)
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        // 입력받은 맵 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        // dist 배열: dist[x][y][wallBroken] 0이면 벽을 부수지 않은 상태, 1이면 벽을 부순 상태
        dist = new int[N][M][2]; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j][0] = dist[i][j][1] = Integer.MAX_VALUE; // 초기값: 매우 큰 값
            }
        }

        q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); // (x, y, 벽을 부수었는지 여부)
        dist[0][0][0] = 1; // 출발지점은 벽을 부수지 않고 1번이므로 dist[0][0][0] = 1

        bfs();

        // 목적지에 도달할 수 있는 최단 거리 출력
        int answer = Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], wallBroken = cur[2];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 벽을 부수지 않은 상태에서 이동
                if (arr[nx][ny] == 0 && dist[nx][ny][wallBroken] == Integer.MAX_VALUE) {
                    dist[nx][ny][wallBroken] = dist[x][y][wallBroken] + 1;
                    q.offer(new int[]{nx, ny, wallBroken});
                }

                // 벽을 부수고 이동할 수 있는 경우 (벽을 부수지 않았다면)
                if (arr[nx][ny] == 1 && wallBroken == 0 && dist[nx][ny][1] == Integer.MAX_VALUE) {
                    dist[nx][ny][1] = dist[x][y][wallBroken] + 1;
                    q.offer(new int[]{nx, ny, 1});
                }
            }
        }
    }
}
