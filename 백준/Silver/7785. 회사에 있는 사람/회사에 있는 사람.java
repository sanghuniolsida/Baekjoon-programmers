import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }
        int cnt = 0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String x = entry.getValue();
            if(x.equals("enter")) {
                cnt++;
            }
        }
        String[] arr = new String[cnt];
        int index = 0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String x = entry.getValue();
            String y = entry.getKey();
            if(x.equals("enter")) {
                arr[index] = y;
                index++;
            }
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--) {
            System.out.println(arr[i]);
        }
    }
}