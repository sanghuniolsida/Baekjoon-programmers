import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][];
        int[][] arr = new int[N][];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new int[i+1];
            dp[i] = new int[i+1];
            for(int j = 0; j < input.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = arr[0][0];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if(j==i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j]+arr[i][j]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < dp[N-1][i]) {
                max = dp[N-1][i];
            }
        }
        System.out.println(max);
    }
}
/*입력 값을 2차원 배열로 받아서 가볼까?*/
