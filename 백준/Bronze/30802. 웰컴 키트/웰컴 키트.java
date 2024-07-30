import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arrSize = new int[6];
        for(int i=0;i<6;i++) {
            arrSize[i] = sc.nextInt();
        }

        int T = sc.nextInt();
        int P = sc.nextInt();
        int cnt = 0;
        for(int i =0;i<6;i++){
            if(arrSize[i] <= T && arrSize[i] != 0) {
                cnt++;
            } else if(arrSize[i] == 0){
                cnt += 0;
            }
            else if(arrSize[i] > T && arrSize[i]%T ==0){
                cnt += arrSize[i]/T;
            } else {
                cnt += arrSize[i]/T + 1;
            }
        }

        int pen1 = N/P;
        int pen2 = N%P;
        System.out.println(cnt);
        System.out.println(pen1 +" "+pen2);
    }
}