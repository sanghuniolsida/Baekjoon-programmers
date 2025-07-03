import java.io.*;
import java.util.*;

public class Main {
    static int T, B;
    static String A; //A는 큐에 string 타입으로 넣을거임
    static int[] arr;
    static boolean[] visited;
    static Queue<String[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* n = ((d1*10 + d2)*10 + d3)*10 + d4 */

        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            arr = new int[10000]; //0~9999
            visited = new boolean[10000];
            String[] commands = new String[10000];

            StringTokenizer st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.add(new String[]{A, ""});
            visited[Integer.parseInt(A)] = true; // 방문한 위치는 ture

            while(!q.isEmpty()) {
                String[] strArr = q.poll();
                int x = Integer.parseInt(strArr[0]);
                String y = strArr[1];

                if(x == B) {
                    System.out.println(y);
                    break;
                }

                int d = D(x);
                if(!visited[d]) {
                    visited[d] = true;
                    q.add(new String[]{Integer.toString(d), y+"D"});
                }

                int s = S(x);
                if(!visited[s]) {
                    visited[s] = true;
                    q.add(new String[]{Integer.toString(s), y+"S"});
                }

                int l = L(x);
                if(!visited[l]) {
                    visited[l] = true;
                    q.add(new String[]{Integer.toString(l), y+"L"});
                }

                int r = R(x);
                if(!visited[r]) {
                    visited[r] = true;
                    q.add(new String[]{Integer.toString(r), y+"R"});
                }
            }
        }
    }

    static int D(int n) {
        return (2*n) % 10000;
    }

    static int S(int n) {
        return (n==0) ? 9999 : n-1;
    }

    static int L(int n) {
        return (n % 1000) * 10 + (n / 1000);
    }

    static int R(int n) {
        return  (n % 10) * 1000 + (n / 10);
    }
}