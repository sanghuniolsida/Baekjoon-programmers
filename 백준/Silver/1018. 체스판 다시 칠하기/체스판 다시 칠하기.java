import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input_num = br.readLine().split(" ");
        int N = Integer.parseInt(input_num[0]);
        int M = Integer.parseInt(input_num[1]);

        char[][] chess = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = s.charAt(j);
            }
        }

        int min_cnt = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt1 = 0;
                int cnt2 = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if ((k + l) % 2 == 0) {
                            if (chess[k][l] != 'W') cnt1++;
                            if (chess[k][l] != 'B') cnt2++;
                        } else {
                            if (chess[k][l] != 'B') cnt1++;
                            if (chess[k][l] != 'W') cnt2++;
                        }
                    }
                }
                int Min = Math.min(cnt1, cnt2);
                if (Min < min_cnt) {
                    min_cnt = Min;
                }
            }
        }
        System.out.println(min_cnt);
    }
}
