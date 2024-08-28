import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stair = Integer.parseInt(br.readLine());
        int[] stair_arr = new int[stair+1];
        stair_arr[0] = 0;
        for(int i = 1; i <= stair; i++) {
            stair_arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[stair+1];
        dp[0] = 0;
        dp[1] = stair_arr[1];
        if(stair >= 2) {
            dp[2] = dp[1] + stair_arr[2];
            for(int i = 3; i <= stair; i++) {
                dp[i] = Math.max(dp[i-2]+stair_arr[i], dp[i-3] + stair_arr[i-1]+stair_arr[i]);
            }
        }
        System.out.println(dp[stair]);
    }
}
