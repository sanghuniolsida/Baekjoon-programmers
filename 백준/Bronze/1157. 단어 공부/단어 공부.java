import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String word = input.toUpperCase(); //소문자->대문자
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                freq[ch-'A']++;
            }
        }
        int max = 0;
        char result = '?';
        boolean duplicate = false;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > max) {
                max = freq[i];
                result = (char)('A' + i);
                duplicate = false;
            } else if(freq[i] == max) {
                duplicate = true;
            }
        }
        if(duplicate) {
            result = '?';
        }
        System.out.println(result);
    }
}
