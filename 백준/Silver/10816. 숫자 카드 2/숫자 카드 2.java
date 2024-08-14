import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");

        for(int i = 0; i < arr1.length; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            sb.append(map.getOrDefault(arr2[i], 0)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}