import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1~10000까지의 숫자.
        boolean[] result = new boolean[10001];

        for(int i=1;i<=10000;i++) {
            int x = i;
            String s = String.valueOf(x);
            for(int j=0;j<s.length();j++) {
                x += Integer.parseInt(String.valueOf(s.charAt(j)));
            }

            if(x <= 10000) {
                result[x] = true;
            }
        }

        for(int i=1;i<result.length;i++) {
            if(!result[i]) {
                System.out.println(i);
            }
        }
    }
}
