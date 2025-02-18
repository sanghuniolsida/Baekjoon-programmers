import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt, homeCnt, N;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        cnt = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j] == 1 && !check[i][j]) {
                    homeCnt = 1;
                    q.offer(new int[]{i,j});
                    check[i][j] = true;
                    int a = bfs();
                    ar.add(a);
                    cnt++; //bfs를 실행하면 단지 수 하나씩 업
                }
            }
        }
        Collections.sort(ar);
        System.out.println(cnt);
        for(int num : ar) {
            System.out.println(num);
        }
    }
    public static int bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(!check[nx][ny] && arr[nx][ny] == 1) {
                    check[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    homeCnt++;
                }
            }
        }
        return homeCnt;
    }
}
