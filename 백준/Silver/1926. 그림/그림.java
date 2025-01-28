import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = new int[N][M];

        for(int i=0;i<N;i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                result[i][j] = -1;
            }
        }
        cnt = 0;
        size = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr[i][j] == 1 && result[i][j] == -1) {
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(size);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        result[x][y] = 1;
        int areaSize = 1;

        while(!q.isEmpty()) {
            int[] a = q.poll();
            int ax = a[0];
            int ay = a[1];
            for(int i=0;i<4;i++) {
                int nx = ax + dx[i];
                int ny = ay + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(arr[nx][ny] == 1 && result[nx][ny] == -1) {
                        result[nx][ny] = result[ax][ay] + 1;
                        q.add(new int[] {nx, ny});
                        areaSize++;
                    }
                }
            }
            size = Math.max(size, areaSize);
        }
    }
}