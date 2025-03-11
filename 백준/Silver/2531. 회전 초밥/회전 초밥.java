import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> sushi = new HashMap<>();
        int result = 0;

        for (int i = 0; i < k; i++) {
            sushi.put(belt[i], sushi.getOrDefault(belt[i], 0) + 1);
        }

        if (!sushi.containsKey(c)) {
            result = sushi.size() + 1;
        } else {
            result = sushi.size();
        }

        for (int i = 1; i < N; i++) {
            int rindex = i - 1;
            int rsushi = belt[rindex];
            sushi.put(rsushi, sushi.get(rsushi) - 1);
            if (sushi.get(rsushi) == 0) {
                sushi.remove(rsushi);
            }

            int addIndex = (i + k - 1) % N;  // 원형으로 돌도록
            int asushi = belt[addIndex];
            sushi.put(asushi, sushi.getOrDefault(asushi, 0) + 1);

            if (!sushi.containsKey(c)) {
                result = Math.max(result, sushi.size() + 1);
            } else {
                result = Math.max(result, sushi.size());
            }
        }

        System.out.println(result);
    }
}
