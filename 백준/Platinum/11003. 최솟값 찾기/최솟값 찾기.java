import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> dq = new LinkedList<>();
        for(int i=0;i<N;i++) {
            if(!dq.isEmpty() && dq.peekFirst()[1] < i-L+1) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && dq.peekLast()[0] > arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{arr[i],i});
            sb.append(dq.peekFirst()[0]).append(" ");
        }
        System.out.println(sb);
    }
}