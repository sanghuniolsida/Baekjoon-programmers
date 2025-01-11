import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        String[] arr = br.readLine().split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);

        for (int i = 1; i <= x; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!q.isEmpty()) {
            for (int i = 1; i < y; i++) {
                q.add(q.poll());
            }
            sb.append(q.poll());
            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
