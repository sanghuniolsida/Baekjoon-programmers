import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //자바에서는 Queue를 생성하기 위해선 LinkedList를 활용해서 생성해야한다.
        Queue<Integer> q = new LinkedList<>();

        int N = sc.nextInt();
        for(int i = 1; i <= N ; i++) {
            q.offer(i);
        }
        while(q.size() > 1) {
            q.poll(); // 가장 먼저 입력된 값 삭제
            q.offer(q.poll()); //그 다음 값 삭제 후 추가
        }
        System.out.println(q.poll());
    }
}
