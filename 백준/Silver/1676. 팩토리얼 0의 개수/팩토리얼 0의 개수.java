import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt_five = 0;
        int cnt_two = 0;

        for(int i=N;i>0;i--) {
            int num1 = i;
            while(num1%5==0) {
                num1 = num1/5;
                cnt_five++;
            }
            while(num1%2==0) {
                num1 = num1/2;
                cnt_two++;
            }
        }
        if(cnt_five == cnt_two) {
            System.out.println(cnt_five);
        } else if(cnt_five > cnt_two) {
            System.out.println(cnt_two);
        } else if(cnt_five < cnt_two) {
            System.out.println(cnt_five);
        }
    }
}
