import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num_arr = br.readLine().split(" ");
        int N = Integer.parseInt(num_arr[0]);
        int M = Integer.parseInt(num_arr[1]);

        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            String[] site_pw = br.readLine().split(" ");
            map.put(site_pw[0], site_pw[1]);
        }

        for(int i=0;i<M;i++) {
            String pw = map.get(br.readLine());
            System.out.println(pw);
        }
    }
}