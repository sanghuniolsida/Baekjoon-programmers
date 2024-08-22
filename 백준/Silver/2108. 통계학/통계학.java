import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //산술 평균
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }
        double average = (double)sum / (double)N;
        int result1 = (int)Math.round(average);

        //중앙값
        Arrays.sort(arr);
        int result2 = arr[N/2];

        //최빈값> 해시맵 사용할까?
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFre = 0;
        List<Integer> modeCandi = new ArrayList<>();

        // 최빈값 후보
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (frequency > maxFre) {
                maxFre = frequency;
                modeCandi.clear();
                modeCandi.add(num);
            } else if (frequency == maxFre) {
                modeCandi.add(num);
            }
        }
        int result3 = 0;

        // 최빈값 후보들을 정렬하고 두 번째로 작은 값
        if (modeCandi.size() > 1) {
            modeCandi.sort(null);
            result3 = modeCandi.get(1);
        } else {
            result3 = modeCandi.get(0);
        }

        //범위
        int result4 = arr[N-1] - arr[0];

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}