import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for(Character c : str.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> iterator = list.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            String[] st = br.readLine().split(" ");
            if(st[0].equals("L")) {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if(st[0].equals("D")) {
                if(iterator.hasNext()) {
                    iterator.next();
                }
            } else if(st[0].equals("B")) {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else if(st[0].equals("P")) {
                char c = st[1].charAt(0);
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
