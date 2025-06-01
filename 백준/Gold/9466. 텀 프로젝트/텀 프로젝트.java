import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited, done;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 팀원 선택은 한명만. 자기 자신을 선택하여 1인팀도 가능.
        // 꼬리 물기 게임과 비슷한거 아닌가? 끝과 끝이 동일하면 팀이 성립된다는거잖아.

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int student_cnt = Integer.parseInt(br.readLine());
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[student_cnt+1];
            visited = new boolean[student_cnt+1];
            done = new boolean[student_cnt+1];
            for(int j=1;j<=student_cnt;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=1;j<=student_cnt;j++) {
                if(!done[j]) {
                    dfs(j);
                }
            }
            System.out.println(student_cnt-count);
        }
    }
    static void dfs(int n) {
        if(visited[n]) {
            done[n] = true;
            count++;
        } else {
            visited[n] = true;
        }
        if(!done[arr[n]]) {
            dfs(arr[n]);
        }
        visited[n] = false;
        done[n] = true;
    }
}
