import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*점화식
        * dp[N] = dp[N-1] + dp[N-2] * 2
        * */
        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[input+1];

        arr[0] = 1;
        arr[1] = 1;

        for(int i=2;i<=input;i++) {
            arr[i] = (arr[i-1] + arr[i-2] * 2) % 10007;
        }
        System.out.println(arr[input]);
    }
}