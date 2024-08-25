import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            int cnt = 0;
            int A = arr[i] / 3;
            int B = arr[i] / 2;

            for (int j = 0; j <= A; j++) {
                for (int k = 0; k <= B; k++) {
                    int remaining = arr[i] - (j * 3 + k * 2);
                    if (remaining >= 0) {
                        int total = j + k + remaining;
                        cnt += combination(total, j) * combination(total - j, k);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static long combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
}
