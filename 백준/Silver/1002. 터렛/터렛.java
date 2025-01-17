import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);
            int r1 = Integer.parseInt(arr[2]);
            int x2 = Integer.parseInt(arr[3]);
            int y2 = Integer.parseInt(arr[4]);
            int r2 = Integer.parseInt(arr[5]);

            double distSq = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
            double dist = Math.sqrt(distSq);

            // 접점 개수
            if (dist == 0 && r1 == r2) {
                System.out.println(-1);
            } else if (dist == r1 + r2 || dist == Math.abs(r1 - r2)) {
                System.out.println(1);
            } else if (dist > r1 + r2 || dist < Math.abs(r1 - r2)) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }
    }
}
