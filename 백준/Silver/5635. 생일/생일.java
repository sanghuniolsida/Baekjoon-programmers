import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][4];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 4; j++) {
                arr[i][j] = input[j];
            }
        }
        String[] str = new String[2];
        int year = Integer.MIN_VALUE;
        int month = Integer.MIN_VALUE;
        int day = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(year < Integer.parseInt(arr[i][3])) {
                year = Integer.parseInt(arr[i][3]);
                str[0] = arr[i][0];
            } else if(year == Integer.parseInt(arr[i][3])) {
                if(Integer.parseInt(arr[i][2]) > month) {
                    str[0] = arr[i][0];
                } else if(Integer.parseInt(arr[i][2]) == month) {
                    if(Integer.parseInt(arr[i][1]) > day) {
                        str[0] = arr[i][0];
                    }
                }
            }
        }
        int year1 = Integer.parseInt(arr[0][3]);
        int month1 = Integer.parseInt(arr[0][2]);
        int day1 = Integer.parseInt(arr[0][1]);
        for(int i = 1; i < n; i++) {
            if(year1 > Integer.parseInt(arr[i][3])) {
                year1 = Integer.parseInt(arr[i][3]);
                month1 = Integer.parseInt(arr[i][2]);
                day1 = Integer.parseInt(arr[i][1]);
                str[1] = arr[i][0];
            } else if(year1 == Integer.parseInt(arr[i][3])) {
                if(Integer.parseInt(arr[i][2]) < month1) {
                    year1 = Integer.parseInt(arr[i][3]);
                    month1 = Integer.parseInt(arr[i][2]);
                    day1 = Integer.parseInt(arr[i][1]);
                    str[1] = arr[i][0];
                } else if(Integer.parseInt(arr[i][2]) == month1) {
                    if(Integer.parseInt(arr[i][1]) < day1) {
                        year1 = Integer.parseInt(arr[i][3]);
                        month1 = Integer.parseInt(arr[i][2]);
                        day1 = Integer.parseInt(arr[i][1]);
                        str[1] = arr[i][0];
                    }
                }
            }
        }
        for(int i = 0; i < 2; i++) {
            System.out.println(str[i]);
        }
    }
}
