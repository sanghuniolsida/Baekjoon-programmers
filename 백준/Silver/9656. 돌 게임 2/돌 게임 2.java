import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
/*돌은 1개 or 3개 가져갈 수 있음.
마지막 돌을 가져가는 사람이 지는 게임이다.
상근이가 이기면 SK, 창영이가 이기면 CY */
