import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int last = -1;

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");

            switch (st[0]) {
                case "push":
                    int value = Integer.parseInt(st[1]);
                    q.add(value);
                    last = value;
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        sb.append(q.poll()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}
