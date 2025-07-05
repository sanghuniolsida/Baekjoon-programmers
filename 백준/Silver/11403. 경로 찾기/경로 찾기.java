import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1->2, 2->3, 3->1
        int G = Integer.parseInt(br.readLine());

        int[][] arr = new int[G][G];
        int[][] result = new int[G][G];
        boolean[][] check = new boolean[G][G];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<G;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<G;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] arrNum = q.poll();
            int x = arrNum[0]; //행
            int y = arrNum[1]; //열

            result[x][y] = 1;
            check[x][y] = true;
            for (int j = 0; j < G; j++) {
                if (arr[y][j] == 1 && !check[x][j]) {
                    result[x][j] = 1;
                    check[x][j] = true;
                    q.add(new int[]{x, j});
                }
            }
        }

        for(int i=0;i<G;i++) {
            for(int j=0;j<G;j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}