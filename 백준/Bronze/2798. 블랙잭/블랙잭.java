import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] str1 = new int[N];

        for (int i = 0; i < N; i++) {
            str1[i] = sc.nextInt();
        }
        int closestSum = Integer.MIN_VALUE;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = str1[i] + str1[j] + str1[k];
                    if (sum == M) {
                        System.out.println(sum);
                        return;
                    }
                    if(sum < M && sum > closestSum) {
                        closestSum = sum;
                    }
                }
            }
        }
        System.out.println(closestSum);
    }
}
