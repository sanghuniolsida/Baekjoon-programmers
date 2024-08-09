import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = 0;
        int num2 = 0;

        String[] arr = new String[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Fizz") || arr[i].equals("Buzz") || arr[i].equals("FizzBuzz")) {
                continue;
            } else {
                num1 = Integer.parseInt(arr[i]);
                num2 = i;
                break;
            }
        }
        if (num2 == 0) {
            num1 += 3;
            if (num1 % 3 == 0 && num1 % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (num1 % 3 == 0 && num1 % 5 != 0) {
                System.out.println("Fizz");
            } else if (num1 % 3 != 0 && num1 % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num1);
            }
        }
        if (num2 == 1) {
            num1 += 2;
            if (num1 % 3 == 0 && num1 % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (num1 % 3 == 0 && num1 % 5 != 0) {
                System.out.println("Fizz");
            } else if (num1 % 3 != 0 && num1 % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num1);
            }
        }
        if (num2 == 2) {
            num1 += 1;
            if (num1 % 3 == 0 && num1 % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (num1 % 3 == 0 && num1 % 5 != 0) {
                System.out.println("Fizz");
            } else if (num1 % 3 != 0 && num1 % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num1);
            }
        }
    }
}