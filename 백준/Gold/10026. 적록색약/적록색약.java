import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int result1;
    static int result2;
    static boolean[][] check;
    static boolean[][] check2;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //적록색약이 아니다 > 빨, 파, 초. 적록생갹이다 > 빨+초, 파
        //bfs, dfs 둘 중 무엇으로 풀어도 상관 없음> 어차피 큐나 스택이 비게 될 때 카운트 시작
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        check = new boolean[N][N];
        check2 = new boolean[N][N];

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        result1 = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!check[i][j]) {
                    result1++;
                    q.offer(new int[] {i,j});
                    check[i][j] = true;
                    bfs1();
                }
            }
        }
        System.out.print(result1+" ");

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        result2 = 0;
        q.clear();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!check2[i][j]) {
                    result2++;
                    q.offer(new int[] {i,j});
                    check2[i][j] = true;
                    bfs2();
                }
            }
        }
        System.out.print(result2);
    }
    public static void bfs1() {
        while(!q.isEmpty()) {
            int[] q_arr = q.poll();
            int n1 = q_arr[0];
            int n2 = q_arr[1];

            for(int i=0;i<4;i++) {
                int nx = n1 + dx[i];
                int ny = n2 + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(arr[nx][ny] == arr[n1][n2] && !check[nx][ny]) {
                    q.offer(new int[] {nx,ny});
                    check[nx][ny] = true;
                }
            }
        }
    }
    public static void bfs2() {
        while(!q.isEmpty()) {
            int[] q_arr = q.poll();
            int n1 = q_arr[0];
            int n2 = q_arr[1];

            for(int i=0;i<4;i++) {
                int nx = n1 + dx[i];
                int ny = n2 + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(arr[nx][ny] == arr[n1][n2] && !check2[nx][ny]) {
                    q.offer(new int[] {nx,ny});
                    check2[nx][ny] = true;
                }
            }
        }
    }
}