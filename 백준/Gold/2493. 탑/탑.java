import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] result = new int[N+1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr[0] = 0; 
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peek();

            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
