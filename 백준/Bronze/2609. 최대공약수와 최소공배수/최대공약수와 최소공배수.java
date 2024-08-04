import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int x_min = 0;
        boolean found = false;

        for(int i=1;i<=num1;i++) {
            for(int j=1;j<=num2;j++) {
                if(num1%i == 0 && num2%j==0 && i==j) {
                    x_min = i;
                }
            }
        }
        System.out.println(x_min);
        for(int i=1;i<10000;i++) {
            for(int j=1;j<10000;j++) {
                if(num1*i == num2*j) {
                    System.out.println(num1*i);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
    }
}
