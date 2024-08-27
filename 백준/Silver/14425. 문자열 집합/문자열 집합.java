import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set1 = new HashSet<>();
        String[] arr1 = br.readLine().split(" ");
        int N = Integer.parseInt(arr1[0]);
        int M = Integer.parseInt(arr1[1]);
        String[] arr2 = new String[M];
        for(int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }
        for(int i = 0; i < M; i++) {
            arr2[i] = br.readLine();
        }
        int cnt = 0;
        for(String s : arr2) {
            if(set1.contains(s)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}