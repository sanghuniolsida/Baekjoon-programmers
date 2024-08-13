import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            Stack<String> stack = new Stack<>();  //문자열을 넣을 스택.
            String[] arr = br.readLine().split(""); //한 글자씩 배열에 넣을거야.
            if(arr[0].equals(".") && arr.length == 1) {
                break;
            }
            for(int i=0;i<arr.length;i++) {
                if(arr[i].equals("(") || arr[i].equals("[")) {
                    stack.push(arr[i]);
                } else if(arr[i].equals(")")) {
                    if(!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(arr[i]);
                    }
                } else if(arr[i].equals("]")) {
                    if(!stack.isEmpty() && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push(arr[i]);
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}