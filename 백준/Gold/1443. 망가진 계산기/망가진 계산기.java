import java.io.*;
import java.util.*;

public class Main {
    static int D, P, result, result2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken()); // 연산 횟수
        result = 0;

        if(P==0) {
            System.out.println(1);
        } else {
            cal(1, 0 ,2);
            if(result==0) {
                result = -1;
            }
            System.out.println(result);
        }
    }
    //재귀로 돌려버리면 P만큼 되겠지!? 될걸
    private static void cal(int x, int cnt, int start) {
        if(String.valueOf(x).length() > D) {
            return;
        }
        if(cnt==P) {
            result = Math.max(x, result);
        }

        for(int i=start;i<=9;i++) {
            cal(x*i, cnt+1, i);

        }
    }
}