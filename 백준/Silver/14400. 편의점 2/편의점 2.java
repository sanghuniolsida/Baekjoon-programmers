import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] x_arr = new int[n];
        int[] y_arr = new int[n];

        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            x_arr[i] = Integer.parseInt(line[0]);
            y_arr[i] = Integer.parseInt(line[1]);
        }

        Arrays.sort(x_arr);
        Arrays.sort(y_arr);

        int x_median = x_arr[x_arr.length/2];
        int y_median = y_arr[y_arr.length/2];

        long x_sum = 0;
        long y_sum = 0;

        for(int i=0;i<n;i++) {
            if(x_median >= x_arr[i]) {
                x_sum += x_median - x_arr[i];
            } else {
                x_sum += x_arr[i] - x_median;
            }
        }
        for(int i=0;i<n;i++) {
            if(y_median >= y_arr[i]) {
                y_sum += y_median - y_arr[i];
            } else {
                y_sum += y_arr[i] - y_median;
            }
        }
        long result = x_sum + y_sum;
        System.out.println(result);
    }
}