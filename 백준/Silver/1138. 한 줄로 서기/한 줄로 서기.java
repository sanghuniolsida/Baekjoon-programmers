import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] line = new int[input+1];
        for(int i=1;i<=input;i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=1;j<=input;j++) {
                if(cnt == 0) {
                    if(line[j]==0) {
                        line[j] = i;
                        break;
                    } else {
                        continue;
                    }
                } else if(line[j] == 0) {
                    cnt--;
                }
            }
        }
        for(int i=1;i<=input;i++) {
            System.out.print(line[i]+" ");
        }
    }
}