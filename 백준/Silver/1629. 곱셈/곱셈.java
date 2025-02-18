import java.util.*;
import java.io.*;

public class Main {
    static long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(recur(A, B, C));
    }

    public static long recur(long x, long y, long z) {
        if (y == 0) return 1;
        long half = recur(x, y / 2, z);
        long result = (half * half) % z;
        if (y % 2 == 1) result = (result * x) % z;
        return result;
    }
}
