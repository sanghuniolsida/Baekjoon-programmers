import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int x = Integer.parseInt(br.readLine());

            String inputArray = br.readLine();
            inputArray = inputArray.substring(1, inputArray.length() - 1);

            LinkedList<Integer> list = new LinkedList<>();
            if(!inputArray.isEmpty()) {
                String[] elements = inputArray.split(",");
                for(String num : elements) {
                    list.add(Integer.parseInt(num.trim()));
                }
            }

            boolean reversed = false;
            boolean error = false;

            for (char cmd : commands.toCharArray()) {
                if (cmd == 'R') {
                    reversed = !reversed;
                } else if (cmd == 'D') {
                    if (list.isEmpty()) {
                        error = true;
                        break;
                    }
                    if(reversed) {
                        list.removeLast();
                    } else {
                        list.removeFirst();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (reversed) {
                    ListIterator<Integer> it = list.listIterator(list.size());
                    while (it.hasPrevious()) {
                        sb.append(it.previous()).append(",");
                    }
                } else {
                    for (int num : list) {
                        sb.append(num).append(",");
                    }
                }

                if (!list.isEmpty()) sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}