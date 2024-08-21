import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] line_length = new int[K];

        for (int i = 0; i < K; i++) {
            line_length[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = 0;
        
        for (int length : line_length) {
            if (length > end) {
                end = length;
            }
        }
        
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            
            for (int length : line_length) {
                cnt += length / mid;
            }
            
            if (cnt >= N) {
                result = mid; 
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
