import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] task = new int[N+1];
        int[] price = new int[N+1];

        for(int i=1;i<N+1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            task[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];

        for(int i=1;i<=N;i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);

            int nextDay = i + task[i];
            if(nextDay <= N+1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + price[i]);
            }
        }

        dp[N + 1] = Math.max(dp[N + 1], dp[N]);

        System.out.println(dp[N + 1]);
    }
}