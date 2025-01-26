import java.io.*;
import java.util.*;
import java.math.BigInteger; // BigInteger 추가

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split("");
        int[] arr = new int[st.length];

        for (int i = 0; i < st.length; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {  
            sum += arr[i];
        }
        
        if (arr[0] != 0 || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            StringBuilder s = new StringBuilder(); 
            for (int i = arr.length - 1; i >= 0; i--) { 
                s.append(arr[i]);
            }

            BigInteger result = new BigInteger(s.toString());
            System.out.println(result);
        }
    }
}
