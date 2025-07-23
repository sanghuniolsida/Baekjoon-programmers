import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        long maxCnt = 0;

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(st.nextToken());
            sum += x;
            maxCnt = Math.max(maxCnt, x);
        }

        if (sum == 1) {
            System.out.println("Happy");
        } else if (maxCnt > sum / 2) {
            System.out.println("Unhappy");
        } else {
            System.out.println("Happy");
        }
    }
}
