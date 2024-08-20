import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()); //문서의 개수
            int B = Integer.parseInt(st.nextToken()); //알고 싶은 문서 출력 순서가 있는 위치

            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[A];
            Queue<Integer> q = new LinkedList<>();
            for(int j=0;j<A;j++) {
                int var = Integer.parseInt(st.nextToken());
                arr[j] = var;
                q.offer(j);
            }
            int cnt = 0;
            while(!q.isEmpty()) {
                boolean check = false;
                int x = q.poll();

                for(int k : arr) {
                    if(arr[x] < k) {
                        q.offer(x);
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    cnt++;
                    arr[x] = 0;
                    if(x == B) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}