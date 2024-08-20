import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");

        int r=31;
        int M=1234567891;
        int[] int_arr = new int[L];
        for(int i=0;i<L;i++){
            int_arr[i] = arr[i].charAt(0)-96;
        }
        long result = 0;

        for(int i=0;i<int_arr.length;i++) {
            long power = (long)Math.pow(r,i) % M;
            result = (result + (power * int_arr[i]) % M) % M;
        }
        System.out.println(result);
    }
}