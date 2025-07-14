import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> do_st = new LinkedList<>();
        Deque<Integer> su_st = new LinkedList<>();
        Queue<Integer> do_q = new LinkedList<>();
        Queue<Integer> su_q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            do_st.addLast(Integer.parseInt(st.nextToken()));
            su_st.addLast(Integer.parseInt(st.nextToken()));
        }

        int do_top = 0;  // 도도 그라운드의 맨 위 카드
        int su_top = 0;  // 수연 그라운드의 맨 위 카드

        for (int turn = 0; turn < M; turn++) {
            if (turn % 2 == 0) { 
                int do_num = do_st.pollLast();
                do_q.add(do_num);
                do_top = do_num;  

                if (do_st.isEmpty()) {
                    System.out.println("su");
                    return;
                }

                if (!su_q.isEmpty() && do_top + su_top == 5) {
                    while (!do_q.isEmpty()) su_st.addFirst(do_q.poll());
                    while (!su_q.isEmpty()) su_st.addFirst(su_q.poll());
                    do_top = 0;
                    su_top = 0;
                } else if (do_top == 5) {
                    while (!su_q.isEmpty()) do_st.addFirst(su_q.poll());
                    while (!do_q.isEmpty()) do_st.addFirst(do_q.poll());
                    do_top = 0;
                    su_top = 0;
                }
            } else { 
                int su_num = su_st.pollLast();
                su_q.add(su_num);
                su_top = su_num;  

                if (su_st.isEmpty()) {
                    System.out.println("do");
                    return;
                }

               if (!do_q.isEmpty() && do_top + su_top == 5) {
                    while (!do_q.isEmpty()) su_st.addFirst(do_q.poll());
                    while (!su_q.isEmpty()) su_st.addFirst(su_q.poll());
                    do_top = 0;
                    su_top = 0;
                } else if (su_top == 5) {
                    while (!su_q.isEmpty()) do_st.addFirst(su_q.poll());
                    while (!do_q.isEmpty()) do_st.addFirst(do_q.poll());
                    do_top = 0;
                    su_top = 0;
                }
            }
        }

        if (do_st.size() > su_st.size()) {
            System.out.println("do");
        } else if (do_st.size() < su_st.size()) {
            System.out.println("su");
        } else {
            System.out.println("dosu");
        }
    }
}