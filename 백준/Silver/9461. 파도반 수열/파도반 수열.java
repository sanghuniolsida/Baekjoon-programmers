import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        long[] result = new long[100];
        result[0] = 1;
        result[1] = 1;
        result[2] = 1;

        for (int i = 0; i < input; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N <= 3) { 
                System.out.println(1);
            } else {
                for (int j = 3; j < N; j++) { 
                    result[j] = result[j - 2] + result[j - 3];
                }
                System.out.println(result[N - 1]); 
            }
        }
    }
}
