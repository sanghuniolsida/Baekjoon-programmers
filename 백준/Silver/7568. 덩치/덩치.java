import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++) {
            for(int j=0;j<2;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] arr2 = new int[N];
        for(int i=0;i<N;i++){
            int cnt = 1;
            for(int j=0;j<N;j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    cnt++;
                }
                arr2[i] = cnt;
            }
        }
        for(int i=0;i<N;i++) {
            System.out.print(arr2[i]+" ");
        }

    }
}
