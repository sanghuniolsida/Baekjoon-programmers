import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int i = 1;
        int i_num = 666;
        
        // .contains("666") -> 문자열에 내가 찾고자 하는게 있는지 확인하는 메소드
        while(i<N) {
            i_num++;
            String str1 = String.valueOf(i_num);
            if(str1.contains("666") || str1.contains("6666") ||str1.contains("66666")) {
                i++;
            }
        }
        System.out.println(i_num);
    }
}
