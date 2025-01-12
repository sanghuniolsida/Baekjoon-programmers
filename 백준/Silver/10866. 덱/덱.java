import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++) {
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(arr[1]));
            } else if(arr[0].equals("push_back")) {
                deque.add(Integer.parseInt(arr[1]));
            } else if(arr[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int x = deque.poll();
                    System.out.println(x);
                }
            } else if(arr[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int x = deque.pollLast();
                    System.out.println(x);
                }
            } else if(arr[0].equals("size")) {
                System.out.println(deque.size());
            } else if(arr[0].equals("empty")) {
                if(deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(arr[0].equals("front")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.peek());
                } else {
                    System.out.println(-1);
                }
            } else if(arr[0].equals("back")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}