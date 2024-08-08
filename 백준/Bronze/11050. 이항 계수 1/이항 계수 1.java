import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int N_multiplier = 1;

        // N! 계산
        for(int i=N;i>=1;i--){
            N_multiplier *= i;
        }
        int K_multiplier = 1;
        for(int i=K;i>=1;i--) {
            K_multiplier *= i;
        }
        int NK_multiplier = 1;
        for(int i=N-K;i>=1;i--) {
            NK_multiplier *= i;
        }
        System.out.println(N_multiplier / (K_multiplier*NK_multiplier));
    }
}
