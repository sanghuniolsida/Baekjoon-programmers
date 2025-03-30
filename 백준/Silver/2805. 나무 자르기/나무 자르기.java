import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            max = Math.max(max,arr[i]);
        }

        int left = 0; // 절단기 최소 높이
        int right = max; // 절단기 최대 높이

        while(left < right) {
            int mid = (right + left) / 2; //mid로 절단기 높이를 조절
            long height = 0;

            for(int num : arr) {
                if(num - mid > 0) {
                    height += num - mid;
                }
            }
            if(height >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}
