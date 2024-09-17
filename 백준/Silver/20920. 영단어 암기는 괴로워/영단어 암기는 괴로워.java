import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input_num = br.readLine().split(" ");
        int N = Integer.parseInt(input_num[0]);
        int M = Integer.parseInt(input_num[1]);

        List<String> str_list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                str_list.add(str);
            }
        }

        Collections.sort(str_list);

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : str_list) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return b.getValue().compareTo(a.getValue());
                    } else if (a.getKey().length() != b.getKey().length()) {
                        return b.getKey().length() - a.getKey().length();
                    } else {
                        return a.getKey().compareTo(b.getKey());
                    }
                }
        );

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            bw.write(pq.poll().getKey() + "\n");
        }
        bw.flush();
    }
}

