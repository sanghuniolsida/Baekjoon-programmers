import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            String command = arr[0];
            int num = 0;

            if (!command.equals("all") && !command.equals("empty")) {
                num = Integer.parseInt(arr[1]);
            }

            if (command.equals("add")) {
                set.add(num);
            } else if (command.equals("remove")) {
                set.remove(num);
            } else if (command.equals("check")) {
                sb.append(set.contains(num) ? 1 : 0).append('\n');
            } else if (command.equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (command.equals("all")) {
                set.clear();
                for (int k = 1; k <= 20; k++) {
                    set.add(k);
                }
            } else if (command.equals("empty")) {
                set.clear();
            }
        }

        System.out.print(sb.toString());
    }
}
