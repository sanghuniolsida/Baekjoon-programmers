import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N]; 
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        HashMap<Long, Integer> freqMap = new HashMap<>();
        for (long num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1); 
        }

        long maxCount = Integer.MIN_VALUE;
        long result = Long.MAX_VALUE;  

        for (Map.Entry<Long, Integer> entry : freqMap.entrySet()) {
            long num = entry.getKey();
            int count = entry.getValue();  

            if (count > maxCount) {
                maxCount = count;
                result = num;
            } else if (count == maxCount && num < result) {
                result = num;
            }
        }
        System.out.println(result);
    }
}
