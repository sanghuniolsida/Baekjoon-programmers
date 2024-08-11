import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int N1 = scanner.nextInt();
        for(int i = 0; i < N1; i++) {
            int num = scanner.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int N2 = scanner.nextInt();
        for(int i = 0; i < N2; i++) {
            int num = scanner.nextInt();
            if(map.containsKey(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
