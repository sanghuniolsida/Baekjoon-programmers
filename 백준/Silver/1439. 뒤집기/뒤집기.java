import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        int cnt = 0;
        for(int i=1;i<input.length;i++){
            if(!input[i].equals(input[i-1])) {
                cnt++;
            }
        }
        if(cnt % 2 == 0) {
            System.out.println(cnt/2);
        } else if(cnt % 2 != 0) {
            int x = (cnt-1)/2 + 1;
            System.out.println(x);
        }
    }
}
