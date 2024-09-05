import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int T = L;
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);
        int[] real_arr = new int[arr[N-1]+1];
        for(int i : arr) {
            real_arr[i] = i;
        }

        int cnt = 0;
        for(int i=1;i<real_arr.length;i++) {
            if(real_arr[i] != 0) {
                L--;
                if(L == 0) {
                    cnt++;
                    L = T;
                }
            } else if(T != L) {
                L--;
                if(L == 0) {
                    cnt++;
                    L = T;
                }
            }
        }
        if(L != T && L != 0) {
            cnt++;
        }
        System.out.println(cnt);
    }
}