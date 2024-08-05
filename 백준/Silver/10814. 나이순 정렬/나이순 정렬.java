import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] arr1 = new String[N][2];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                arr1[i][j] = sc.next();
            }
        }
        
        // 배열 정렬
        Arrays.sort(arr1, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
