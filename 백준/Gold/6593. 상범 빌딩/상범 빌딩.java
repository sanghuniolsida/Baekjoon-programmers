import java.util.*;
import java.io.*;

public class Main {
    static int L,R,C;
    static char[][][] arr;
    static boolean[][][] check;
    static int[][][] result;
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); //층수
            R = Integer.parseInt(st.nextToken()); //행
            C = Integer.parseInt(st.nextToken()); //열
            q = new LinkedList<>();
            if(L == 0 ) break;
            arr = new char[L][R][C];
            result = new int[L][R][C];
            check = new boolean[L][R][C];

            for(int i=0;i<L;i++) {
                for(int j=0;j<R;j++) {
                    String str = br.readLine();
                    for(int k=0;k<C;k++) {
                        arr[i][j][k] = str.charAt(k);
                        if(arr[i][j][k] == 'S') {
                            q.offer(new int[]{i,j,k});
                            result[i][j][k] = 0;
                            check[i][j][k] = true;
                        }
                    }
                }
                String s = br.readLine();
            }
            int time = bfs();
            System.out.println(time == -1 ? "Trapped!" : "Escaped in " + time + " minute(s).");
        }
    }
    public static int bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2];

            for(int i=0;i<6;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L) continue;
                if(!check[nz][nx][ny] && arr[nz][nx][ny] == '.') {
                    q.offer(new int[]{nz,nx,ny});
                    check[nz][nx][ny] = true;
                    result[nz][nx][ny] = result[z][x][y] + 1;
                }
                if(!check[nz][nx][ny] && arr[nz][nx][ny] == 'E') {
                    result[nz][nx][ny] = result[z][x][y] + 1;
                    check[nz][nx][ny] = true;
                    return result[nz][nx][ny];
                }
            }
        }
        return -1;
    }
}