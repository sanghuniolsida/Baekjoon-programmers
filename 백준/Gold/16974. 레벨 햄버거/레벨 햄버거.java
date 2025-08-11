import java.io.*;
import java.util.*;

public class Main {
    static long[] length = new long[51];
    static long[] patty = new long[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        length[0] = 1;
        patty[0] = 1;

        for (int i = 1; i <= N; i++) {
            length[i] = length[i-1] * 2 + 3;
            patty[i] = patty[i-1] * 2 + 1;
        }

        System.out.println(Lbuger(N, X));
    }

    static long Lbuger(int level, long x) {
        if (level == 0) {
            return x > 0 ? 1 : 0;
        }

        if (x <= 1) {
            return 0;
        } else if (x <= 1 + length[level - 1]) {
            return Lbuger(level - 1, x - 1);
        } else if (x == 1 + length[level - 1] + 1) {
            return patty[level - 1] + 1;
        } else if (x <= 1 + length[level - 1] + 1 + length[level - 1]) {
            return patty[level - 1] + 1 + Lbuger(level - 1, x - 1 - length[level - 1] - 1);
        } else {
            return patty[level];
        }
    }
}