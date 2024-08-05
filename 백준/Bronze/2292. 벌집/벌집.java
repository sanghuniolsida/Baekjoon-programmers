import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt =1; // 최소 개수의 방 세기
        int rule_num1 = 2;
        int rule_num2 = 7;

        int N = sc.nextInt(); // 몇번 방으로 갈지

        if(N == 1) {
            System.out.println(1);
            return;
        }

        while(true) {
            if (rule_num1 <= N && rule_num2 >= N) {
                System.out.println(cnt+1);
                break;
            }
            cnt++;
            rule_num1 = rule_num2 + 1;
            rule_num2 = rule_num1 + 6 * cnt - 1;
        }
        // 2~7 > 1
        // 8~19 > 2
        // 20~37 > 3
        // 38~61 >4
        // 62~ >5
        //5 11 17
    }
}
