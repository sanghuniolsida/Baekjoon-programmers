import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = new int[K];
        
        if (N < K * (K + 1) / 2) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < K; i++) {
            arr[i] = i + 1; 
            N -= (i + 1);   
        }
 
        int idx = K - 1; 
        while (N > 0) {
            arr[idx]++;
            N--;
            if (idx > 0) {
                idx--;
            } else {
                idx = K - 1; 
            }
        }
        System.out.println(arr[K - 1] - arr[0]);
    }
}
