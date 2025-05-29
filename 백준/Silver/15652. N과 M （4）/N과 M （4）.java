import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(1,0);
        System.out.println(sb);
    }

    public static void dfs(int num, int depth) {
        if(depth == M) {
            for(int k : arr) {
                sb.append(k).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=num;i<=N;i++) {
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}