import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];
        for (char c : input.toCharArray()) {
            alphabet[c - 'A']++;
        }

        int oddCount = 0;
        for (int count : alphabet) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        char[] result = new char[input.length()];
        int left = 0, right = input.length() - 1;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            while (alphabet[i] >= 2) {
                result[left++] = (char) (i + 'A');
                result[right--] = (char) (i + 'A');
                alphabet[i] -= 2;
            }
            if (alphabet[i] == 1) {
                mid = (char) (i + 'A'); 
            }
        }
        
        if (input.length() % 2 == 1) {
            result[input.length() / 2] = mid;
        }
        System.out.println(new String(result));
    }
}