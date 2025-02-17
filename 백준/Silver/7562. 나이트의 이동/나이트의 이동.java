import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            check = new boolean[N][N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] a = {Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())};
            int[] b = {Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())};
            q.offer(a);
            check[a[0]][a[1]] = true;

            bfs();
            q.clear();
            System.out.println(arr[b[0]][b[1]]);
        }
    }
    public static void bfs() {
        while(!q.isEmpty()) {
            int[] aa = q.poll();
            int x = aa[0];
            int y = aa[1];
            for(int i=0;i<8;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(!check[nx][ny]) {
                    q.offer(new int[] {nx,ny});
                    arr[nx][ny] = arr[x][y] + 1;
                    check[nx][ny] = true;
                }
            }
        }
    }
}