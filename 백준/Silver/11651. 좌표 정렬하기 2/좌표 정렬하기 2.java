import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

       Arrays.sort(arr, new Comparator<int[]>() {
           @Override
           public int compare(int[] a, int[] b) {
               if(a[1] == b[1]) {
                   return Integer.compare(a[0], b[0]);
               } else {
                   return Integer.compare(a[1], b[1]);
               }
           }
       });
        for(int i=0;i<N;i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
