import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input_num = br.readLine().split(" ");
        int num1 = Integer.parseInt(input_num[0]); 
        int num2 = Integer.parseInt(input_num[1]); 
        String str = br.readLine(); 
        int[] required = new int[4]; 
        String[] inputNum = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(inputNum[i]);
        }

        int[] current = new int[4];
        
        for (int i = 0; i < num2; i++) {
            char c = str.charAt(i);
            addChar(current, c);
        }

        int result = 0;
        if (isValid(current, required)) {
            result++;
        }

        for (int i = num2; i < num1; i++) {
            char removeChar = str.charAt(i - num2);
            removeChar(current, removeChar);

            char addChar = str.charAt(i);
            addChar(current, addChar);

            if (isValid(current, required)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void addChar(int[] current, char c) {
        if (c == 'A') current[0]++;
        else if (c == 'C') current[1]++;
        else if (c == 'G') current[2]++;
        else if (c == 'T') current[3]++;
    }
    
    private static void removeChar(int[] current, char c) {
        if (c == 'A') current[0]--;
        else if (c == 'C') current[1]--;
        else if (c == 'G') current[2]--;
        else if (c == 'T') current[3]--;
    }

    private static boolean isValid(int[] current, int[] required) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}