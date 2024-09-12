import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        arr[0] = 0;
        int k = 0;
        for(int i=1;i<N+1;i++) {
            arr[i] = Integer.parseInt(input[k]);
            k++;
        }
        dp[0] = 0;
        for(int i=1;i<N+1;i++) {
            dp[i] = arr[i];
        }
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}

