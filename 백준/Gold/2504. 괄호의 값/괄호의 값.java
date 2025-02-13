import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack = new Stack<>();

        int result = 0;
        boolean invalid = false;  

        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i));

            if (ch.equals("(") || ch.equals("[")) {
                stack.push(ch);
            } else if (ch.equals(")")) {
                if (stack.isEmpty()) {
                    invalid = true;
                    break;
                }
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                } else {
                    int sum = 0;
                    while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                        sum += Integer.parseInt(stack.pop());
                    }
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        invalid = true;
                        break;
                    }
                    stack.pop();  
                    stack.push(String.valueOf(sum * 2));
                }
            } else if (ch.equals("]")) {
                if (stack.isEmpty()) {
                    invalid = true;
                    break;
                }
                if (stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                } else {
                    int sum = 0;
                    while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                        sum += Integer.parseInt(stack.pop());
                    }
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        invalid = true;
                        break;
                    }
                    stack.pop(); 
                    stack.push(String.valueOf(sum * 3));
                }
            }
        }

        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (!Character.isDigit(top.charAt(0))) {
                invalid = true;
                break;
            }
            result += Integer.parseInt(top);
        }

        System.out.println(invalid ? 0 : result);
    }
}
