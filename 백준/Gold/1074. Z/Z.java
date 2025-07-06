import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(z(N, r, c));
    }

    static int z(int n, int r, int c) {
        if(n==0) return 0;

        int half = (int)Math.pow(2, n-1);
        int area = half*half;

        if(r < half && c < half) {
            return z(n-1, r, c);
        }  else if (r < half && c >= half) {
            return area * 1 + z(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return area * 2 + z(n - 1, r - half, c);
        } else {
            return area * 3 + z(n - 1, r - half, c - half);
        }
    }
}