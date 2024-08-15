import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        int k = 0;
        StringBuilder result = new StringBuilder();

        while (s2.size() < n) {
            if (!s1.isEmpty() && s1.peek() == arr[k]) {
                k++;
                s2.push(s1.pop());
                result.append("-\n");
            } else if (!s1.isEmpty() && s1.peek() > arr[k]) {
                System.out.println("NO");
                return;
            } else {
                if (num > n) {
                    System.out.println("NO");
                    return;
                }
                s1.push(num);
                result.append("+\n");
                num++;
            }
        }

        System.out.print(result);
    }
}
