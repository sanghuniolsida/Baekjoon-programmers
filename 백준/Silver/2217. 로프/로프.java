import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int maxWeight = 0;

        for(int i = 0; i < num; i++) {
            int weight = arr[i] * (num - i);
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.println(maxWeight);
    }
}
