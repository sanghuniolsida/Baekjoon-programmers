import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //우선 한 자리 숫자는 한수겠네.
        //두 자리 숫자도 한수 아닌가?
        //100이상부터는 구분지어 해주면 될듯?
        int input = Integer.parseInt(br.readLine());
        int cnt = 0;

        if(input>=100) {
            cnt = 99;
            for(int i=100;i<=input;i++) {
                String str = String.valueOf(i); //정수형->문자형
                String[] arr = new String[str.length()];
                for (int j = 0; j < str.length(); j++) {
                    arr[j] = String.valueOf(str.charAt(j));
                }
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int c = a - b;
                int cnt2 = 1;
                for (int k = 1; k < arr.length - 1; k++) {
                    int d = Integer.parseInt(arr[k]);
                    int e = Integer.parseInt(arr[k+1]);
                    if(d-e == c) {
                        cnt2++;
                    }
                }
                if(cnt2 == arr.length-1) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        } else {
            cnt = input;
            System.out.println(cnt);
        }
    }
}