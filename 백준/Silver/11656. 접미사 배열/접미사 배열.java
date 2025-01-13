import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = new String[input.length()];
        for(int i=0;i<input.length();i++) {
            String str = input.substring(i, input.length());
            arr[i] = str;
        }

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
