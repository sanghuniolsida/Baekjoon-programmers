import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCasecnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < TestCasecnt; i++) {
            PriorityQueue<Integer> min_pq = new PriorityQueue<>();
            PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> Map = new HashMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                String[] arr1 = br.readLine().split(" ");
                int num = Integer.parseInt(arr1[1]);
                if (arr1[0].equals("I")) {
                    min_pq.add(num);
                    max_pq.add(num);
                    Map.put(num, Map.getOrDefault(num, 0) + 1);
                } else if (arr1[0].equals("D")) {
                    if (num == 1) {
                        if (!max_pq.isEmpty()) {
                            int max = max_pq.poll();
                            while (Map.getOrDefault(max, 0) == 0 && !max_pq.isEmpty()) {
                                max = max_pq.poll();
                            }
                            if (Map.getOrDefault(max, 0) > 0) {
                                Map.put(max, Map.get(max) - 1);
                            }
                        }
                    } else {
                        if (!min_pq.isEmpty()) {
                            int min = min_pq.poll();
                            while (Map.getOrDefault(min, 0) == 0 && !min_pq.isEmpty()) {
                                min = min_pq.poll();
                            }
                            if (Map.getOrDefault(min, 0) > 0) {
                                Map.put(min, Map.get(min) - 1);
                            }
                        }
                    }
                }
            }
            while (!min_pq.isEmpty() && Map.getOrDefault(min_pq.peek(), 0) == 0) {
                min_pq.poll();
            }
            while (!max_pq.isEmpty() && Map.getOrDefault(max_pq.peek(), 0) == 0) {
                max_pq.poll();
            }
            if (min_pq.isEmpty() || max_pq.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(max_pq.peek() + " " + min_pq.peek());
            }
        }
    }
}
