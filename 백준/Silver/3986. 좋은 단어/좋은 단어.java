import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //단어 개수
        int cnt = 0; //좋은 단어 셀 카운트
        for(int i=0;i<T;i++) {
            Stack<String> stack = new Stack<>();
            String[] str = br.readLine().split("");

            for(int j=0;j<str.length;j++) {
                if(stack.isEmpty()) {
                    stack.push(str[j]);
                } else if(!stack.isEmpty() && !stack.peek().equals(str[j])) {
                    stack.push(str[j]);
                } else if(!stack.isEmpty() && stack.peek().equals(str[j])) {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}