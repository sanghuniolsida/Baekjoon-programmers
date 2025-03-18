import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static char[] ch;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        M = N / 2; // 연산자 개수
        arr = new int[M+1]; // 숫자 개수
        ch = new char[M];
        for(int i=0;i<N;i++) {
            if(i%2==0) {
                arr[i/2] = Integer.parseInt(String.valueOf(s.charAt(i)));
            } else {
                ch[i/2] = s.charAt(i);
            }
        }

        result = Integer.MIN_VALUE;
        dfs(arr[0],0);
        System.out.println(result);

    }
    public static void dfs(int x, int idx) {
        if(idx >= M) {
            result = Math.max(x,result);
            return;
        }
        int x1 = operate(ch[idx], x, arr[idx+1]);
        dfs(x1, idx+1);
        if(idx+1 < M) {
            int x2 = operate(ch[idx+1], arr[idx+1], arr[idx+2]);
            dfs(operate(ch[idx], x, x2), idx+2);
        }
    }
    public static int operate(char op, int n1, int n2) {
        if(op == '+') {
            return n1+n2;
        } else if(op == '-') {
            return n1-n2;
        } else {
            return n1*n2;
        }
    }
}
