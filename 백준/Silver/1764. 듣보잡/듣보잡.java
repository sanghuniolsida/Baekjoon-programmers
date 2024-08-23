import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        HashMap<Integer, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for(int i=1; i <= N+M; i++) {
            String s = br.readLine();
            map.put(i, s);

            if(!set.add(s)){ //중복 문자열이면 집합에 추가가 안되겠지.
                set2.add(s);
            }
        }
        ArrayList<String> arrays = new ArrayList<>(set2);
        Collections.sort(arrays);
        System.out.println(arrays.size());
        for(String s : arrays) {
            System.out.println(s);
        }
    }
}