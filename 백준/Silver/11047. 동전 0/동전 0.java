import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        int[] arr2 = new int[N];

        int count = 0;
        for(int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
            if(arr2[i] <= K) {
                count++;
            }
        }
        int[] arr3 = new int[count];
        for(int i = 0; i < count; i++) {
            arr3[i] = arr2[i];
        }
        int cnt = 0;
        int result = K;
        int index = count - 1;
        while(result != 0) {
            if(result >= arr3[index]) {
                result -= arr3[index];
                cnt++;
            } else {
                index--;
                }
            }
        System.out.println(cnt);
        }
    }