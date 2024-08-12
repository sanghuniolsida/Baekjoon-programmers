import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer>q =new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            String[] input = br.readLine().split(" ");
            String s = input[0];

            if(s.equals("push")) {
                int num = Integer.parseInt(input[1]);
                q.offer(num);
            } else if(s.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                    q.poll();
                }
            } else if(s.equals("size")) {
                System.out.println(q.size());
            } else if(s.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(s.equals("front")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                }
            } else if(s.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(((LinkedList<Integer>)q).getLast());
                }
            }
        }
    }
}
