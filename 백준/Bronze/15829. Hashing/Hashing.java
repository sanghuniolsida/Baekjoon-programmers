import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        
        int r = 31;
        int M = 1234567891;
        
        long result = 0;
        long rPower = 1; // r^0
        
        for(int i = 0; i < L; i++) {
            int charValue = arr[i] - 'a' + 1; // 'a' -> 1, 'b' -> 2, ...
            result = (result + (charValue * rPower) % M) % M;
            rPower = (rPower * r) % M; // r^i 를 계산하며, 매번 M으로 나눈 나머지를 저장
        }
        
        System.out.println(result);
    }
}
