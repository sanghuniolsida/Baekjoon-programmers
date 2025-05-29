import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;         // 현재 수열
    static int[] nums;        // 입력 숫자 저장
    static boolean[] visited; // 중복 방지
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        nums = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(prev == nums[i]) continue;

            visited[i] = true;
            arr[depth] = nums[i];
            dfs(depth + 1);
            visited[i] = false;
            prev = nums[i];
        }
    }
}