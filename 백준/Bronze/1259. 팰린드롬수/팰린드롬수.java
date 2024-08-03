import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int N = sc.nextInt();
            if(N == 0) break;
            String str1 = Integer.toString(N); //int->String
            String[] arr1 = str1.split("");
            String[] arr2 = new String[arr1.length];
            for(int i=0;i<arr1.length;i++) {
                arr2[i] = arr1[arr1.length-i-1];
            }

            String s1 = String.join("",arr1); // 배열을 문자열로 합치기
            String s2 = String.join("",arr2);
            if(s1.equals(s2)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
