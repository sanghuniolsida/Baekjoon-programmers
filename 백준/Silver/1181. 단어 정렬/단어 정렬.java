import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr1 = new String[N];

        for(int i=0;i<N;i++) {
            arr1[i] = sc.next();
        }
        // 중복 제거
        String[] arr2 = Arrays.stream(arr1).distinct().toArray(String[]::new);

        // 사전 순서에 따른 정렬
        Arrays.sort(arr2);
        // 길이에 따른 순서 정렬
        for(int i=0;i<arr2.length;i++) {
            for(int j=1;j<arr2.length;j++) {
                if(arr2[j].length()<arr2[j-1].length()) {
                    String temp = arr2[j-1];
                    arr2[j-1] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        for(int i=0;i<arr2.length;i++) {
            System.out.println(arr2[i]);
        }
    }
}
