import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] arr2 = new int[arr.length];
        
        for(int i=0;i<arr.length;i++) {
            arr2[i] = Integer.parseInt(arr[i]);    
        }
        Arrays.sort(arr2);
        System.out.println(arr2[1]);
    }
}
