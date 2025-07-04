import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxLen = 0;
        int bestSecond = 0;
        List<Integer> arrList = new ArrayList<>();

        for (int i = N / 2; i <= N; i++) {
            List<Integer> arrList2 = new ArrayList<>();
            int first = N;
            int second = i;

            arrList2.add(first);
            arrList2.add(second);

            while (true) {
                int next = first - second;
                if (next < 0) break;

                arrList2.add(next);
                first = second;
                second = next;
            }

            if (arrList2.size() > maxLen) {
                maxLen = arrList2.size();
                bestSecond = i;
                arrList = arrList2;
            }
        }

        System.out.println(maxLen);
        for (int num : arrList) {
            System.out.print(num + " ");
        }
    }
}