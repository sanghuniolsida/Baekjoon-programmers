import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        HashSet<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s);
        }

        int max = Integer.MIN_VALUE;
        String result = "none";

        for (String str : set) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (str.equals(arr[i])) {
                    cnt++;
                }
            }

            if (cnt > max) {
                max = cnt;
                result = str;
            } else if (cnt == max && str.compareTo(result) < 0) {
                result = str;
            }
        }

        System.out.println(result);
    }
}
