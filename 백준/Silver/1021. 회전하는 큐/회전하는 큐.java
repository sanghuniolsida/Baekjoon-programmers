import java.io.*;
import java.util.*;

public class Main {
    static int a, b;
    static LinkedList<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        StringTokenizer stt = new StringTokenizer(br.readLine());
        int[] arr = new int[b];
        for(int i=0;i<b;i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
        }

        for (int i = 1; i <= a; i++) {
            dq.addLast(i);
        }

        int cnt = 0;
        for (int x : arr) {
            if(check(x)) {
                while (x != dq.get(0)) {
                    dq.addLast(dq.poll());
                    cnt++;
                }
            } else {
                while (x != dq.get(0)) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
            }
            dq.poll();
        }
        System.out.println(cnt);
    }

    public static boolean check(int a) {
        for(int i=0;i<=dq.size()/2;i++) {
            if(dq.get(i) == a) {
                return true;
            }
        }
        return false;
    }
}
