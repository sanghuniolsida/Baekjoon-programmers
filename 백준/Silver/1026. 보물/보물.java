import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        int[] A = new int[input];
        int[] B = new int[input];
        int[] C = new int[input];
        int S = 0;

        //배열A만 재정렬하는 것. 배열B에서 큰 요소와 배열A의 작은 요소를 매칭해주면 될듯
        for(int i=0;i<arr1.length;i++) {
            A[i] = Integer.parseInt(arr1[i]);
        }
        Arrays.sort(A); //오름차순 정렬

        for(int i=0;i<arr2.length;i++) {
            B[i] = Integer.parseInt(arr2[i]);
        }
        Arrays.sort(B);

        int j=0;
        for(int i=arr2.length-1;i>=0;i--) {
            C[j] = B[i];
            j++;
        }
        for(int i=0;i<input;i++) {
            int sum = A[i]*C[i];
            S+=sum;
        }
        System.out.println(S);
    }
}