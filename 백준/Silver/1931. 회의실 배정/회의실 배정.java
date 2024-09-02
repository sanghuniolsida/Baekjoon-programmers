import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        //comparator 클래스 구현
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int k = 0;
        int max_cnt = 0;
        int possible = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i][0] >= possible) {
                possible = arr[i][1];
                max_cnt++;
            }
        }
        System.out.println(max_cnt);
    }
}
/*하나씩 잡고 쭉 돌려주면 되지 않을까?
변수 하나 지정해서 기준으로 잡은 회의 다음 가능한 회의를 변수에 넣고 반복문으로 전체
탐색하면서 회의시간이 가장 짧으면서 다음 회의가 가능한 회의를 변수에 새로 업데이트해주는 방법.
뭔가 느낌이 시간 복잡도가 클거 같기도 하고...

아? 회의가 끝나는 시간을 기준으로 정렬을 해야겠다!
그래야 전체 탐색이 아닌 그 뒷 시간 회의들만 탐색하니까 탐색 시간을 줄일 수 있을듯
 */