import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int cnt_zero;
    static int cnt_one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCaseNum = Integer.parseInt(br.readLine());
        int[] arr1 = new int[TestCaseNum];
        for(int i = 0; i < TestCaseNum; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < TestCaseNum; i++) {
            cnt_zero = 0; // 초기화
            cnt_one = 0; // 초기화
            fibonacci(arr1[i]);
            System.out.println(cnt_zero + " " + cnt_one);
        }
    }

    public static void fibonacci(int n) {
        if (n == 0) {
            cnt_zero = 1;
            cnt_one = 0;
        } else if (n == 1) {
            cnt_zero = 0;
            cnt_one = 1;
        } else {
            int[] zeroCount = new int[n + 1];
            int[] oneCount = new int[n + 1];

            zeroCount[0] = 1;
            oneCount[0] = 0;
            zeroCount[1] = 0;
            oneCount[1] = 1;

            for (int i = 2; i <= n; i++) {
                zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
                oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
            }

            cnt_zero = zeroCount[n];
            cnt_one = oneCount[n];
        }
    }
}
