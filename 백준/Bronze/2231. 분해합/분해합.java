import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean found = false;

        for(int i=1;i<N;i++) {
            String str_num = Integer.toString(i); //int->String
            String[] arr1 = str_num.split("");
            int sum = 0;
            int result = i;
            for (int j = 0; j < arr1.length; j++) {
                sum += Integer.parseInt(arr1[j]);
            }
            result += sum;
            if (result == N) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println(0);
        }
    }
}
