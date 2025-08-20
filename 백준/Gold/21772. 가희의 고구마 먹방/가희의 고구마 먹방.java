import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static char[][] board;
    static int answer = 0;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int t, int eaten) {
        answer = Math.max(answer, eaten);
        if (t == T) return;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (board[nx][ny] == '#') continue;

            if (board[nx][ny] == 'S') {
                board[nx][ny] = '.';
                dfs(nx, ny, t + 1, eaten + 1);
                board[nx][ny] = 'S';          
            } else {
                dfs(nx, ny, t + 1, eaten);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        int sx = 0, sy = 0;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                if (ch == 'G') { sx = i; sy = j; ch = '.'; }
                board[i][j] = ch;
            }
        }

        dfs(sx, sy, 0, 0);
        System.out.println(answer);
    }
}