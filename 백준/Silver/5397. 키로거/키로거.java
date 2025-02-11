import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            LinkedList<Character> list = new LinkedList<>();
            String str = br.readLine();
            ListIterator<Character> iterator = list.listIterator();
            while(iterator.hasNext()) {
                iterator.next();
            }
            for(char c : str.toCharArray()) {
                if(c == '<') {
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if(c == '>') {
                    if(iterator.hasNext()) {
                        iterator.next();
                    }
                } else if(c == '-') {
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : list) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}