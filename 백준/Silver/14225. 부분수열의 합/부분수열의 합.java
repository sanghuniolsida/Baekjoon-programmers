import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        int[] arr= new int[S];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int target = 1; // 만들 수 있는 최소값

        for(int i=0;i<S;i++) {
            if(arr[i] > target) {
                break;
            }

            target += arr[i];
        }

        System.out.println(target);
    }
}