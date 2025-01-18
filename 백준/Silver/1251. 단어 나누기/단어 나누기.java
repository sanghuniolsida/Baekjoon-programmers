import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //브르투 포스-> 전체 순회..
        //list에 모든 경우의 수를 넣어서 정렬.
        LinkedList<String> list = new LinkedList<>();
        String input = br.readLine();

        for(int i=2;i<input.length();i++) {
            for(int j=1;j<i;j++) {
                StringBuilder str1 = new StringBuilder(input.substring(0,j));
                StringBuilder str2 = new StringBuilder(input.substring(j,i));
                StringBuilder str3 = new StringBuilder(input.substring(i));

                String str4 = str1.reverse().toString();
                String str5 = str2.reverse().toString();
                String str6 = str3.reverse().toString();

                list.add(str4+str5+str6);
            }
        }
        Collections.sort(list);
        System.out.println((list.pop()));
    }
}