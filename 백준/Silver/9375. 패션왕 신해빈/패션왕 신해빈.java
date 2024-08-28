import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            HashSet<String> set = new HashSet<>();
            int M = Integer.parseInt(br.readLine());
            String[] arr1 = new String[M];
            for(int j = 0; j < M; j++) {
                String[] input = br.readLine().split(" ");
                arr1[j] = input[1];
                set.add(arr1[j]);
            }
            int[] cnt = new int[set.size()];
            int result = 1;
            int k = 0;
            for(String s : set) {
                int count = 0;
                for(int j = 0; j < arr1.length; j++) {
                    if(s.equals(arr1[j])) {
                        count++;
                    }
                }
                cnt[k] = count+1;
                k++;
            }
            for(int j = 0; j < cnt.length; j++) {
                result *= cnt[j];
            }
            System.out.println(result-1);
        }
    }
}
