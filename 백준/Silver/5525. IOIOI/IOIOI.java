import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N+1개의 I, N개의 O
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;
        int I_cnt = N+1;
        int O_cnt = N;

        int total = I_cnt + O_cnt;
        String str = "";

        for(int i=0;i<=M-total;i++) {
            if(S.charAt(i) == 'I') {
                str = S.substring(i, i+total);

                int x = 0;
                int y = 0;
                for(int j=0;j<str.length();j++) {
                    if(j%2 == 0 && str.charAt(j) == 'I') {
                        x++;
                    } else if(j%2 != 0 && str.charAt(j) == 'O') {
                        y++;
                    }
                }
                if(x == I_cnt && y == O_cnt) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}