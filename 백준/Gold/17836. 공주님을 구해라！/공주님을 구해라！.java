import java.io.*;
import java.util.*;

public class Main {
    static int N,M,T;
    static int[][] arr;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        int k = 0;
        int l = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    k=i;
                    l=j;
                }
            }
        }

        int answer = ((N-1) - k) + ((M-1) - l);
        bfs(0,0);

        int realResult1 = result[N-1][M-1];
        int realResult2 = result[k][l] + answer;
        if(result[k][l] == 0) {
            realResult2 = 0;
        }
        int realreal = -1;
        if(realResult1 != 0 && realResult2 != 0) {
            realreal = Math.min(realResult1,realResult2);
        } else if(realResult1 == 0 && realResult2 != 0) {
            realreal = realResult2;
        } else if(realResult1 != 0 && realResult2 == 0) {
            realreal = realResult1;
        }

        if(realreal == -1 || realreal > T) {
            System.out.println("Fail");
        } else {
            System.out.println(realreal);
        }
    }

    public static void bfs(int a,int b) {
        q.add(new int[] {0,0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(arr[nx][ny] != 1 && !visited[nx][ny]) {
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                    result[nx][ny] = result[x][y] + 1;
                }
            }
        }
    }
}
