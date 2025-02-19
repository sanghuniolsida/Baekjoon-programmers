import java.util.*;
import java.io.*;

public class Main {
    static int N, area, real;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        real = 0;
        int maxNum = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(maxNum < arr[i][j]) {
                    maxNum = arr[i][j];
                }
            }
        }

        for(int h = 0; h <= maxNum; h++) {
            check = new boolean[N][N];
            area = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] > h && !check[i][j]) {
                        q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        check[i][j] = true;
                        bfs(h);
                        area++;
                    }
                }
            }

            real = Math.max(real, area);
        }

        System.out.println(real);
    }

    public static void bfs(int height) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny] && arr[nx][ny] > height) {
                    q.offer(new int[]{nx, ny});
                    check[nx][ny] = true;
                }
            }
        }
    }
}
