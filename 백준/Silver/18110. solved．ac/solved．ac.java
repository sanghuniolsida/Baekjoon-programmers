import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //절삭 평균-> 위 아래 각각 15%씩 반영 안 함.
        int n = Integer.parseInt(br.readLine());
        int[] question_nan2do = new int[n];
        for (int i = 0; i < n; i++) {
            question_nan2do[i] = Integer.parseInt(br.readLine());
        }
        // 배열 오름차순으로 정렬
        Arrays.sort(question_nan2do);
        double fifteenpercnet1 = Math.round((double)n * 0.15);
        int fifteenpercent2 = (int)fifteenpercnet1;

        int sum = 0;
        for(int i=0;i<question_nan2do.length;i++){
            if(i < fifteenpercent2){
                question_nan2do[i] = 0;
            } else if(i > n-(fifteenpercent2+1)) {
                question_nan2do[i] = 0;
            }
            sum += question_nan2do[i];
        }
        int cont = n - fifteenpercent2*2;
        double sum_average = (double)sum / (double)cont;
        int result = (int)Math.round(sum_average);
        System.out.println(result);
    }
}