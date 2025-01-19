import java.util.*;
import java.io.*;

public class Main{

    public static int white = 0;
    public static int blue = 0;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        arr = new int[input][input];
        StringTokenizer st;

        for(int i=0;i<input;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0;j<input;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,input);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if(check(row, col, size)) {
            if(arr[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newsize = size / 2;
        partition(row, col, newsize);
        partition(row, col+newsize, newsize);
        partition(row+newsize, col, newsize);
        partition(row+newsize, col+newsize, newsize);
    }

    public static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
