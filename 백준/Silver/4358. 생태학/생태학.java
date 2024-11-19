import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        String str;
        int totalCount = 0;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            totalCount++;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            double percentage = (map.get(key) / (double) totalCount) * 100;
            sb.append(key).append(" ").append(String.format("%.4f", percentage)).append("\n");
        }

        System.out.print(sb);
    }
}
