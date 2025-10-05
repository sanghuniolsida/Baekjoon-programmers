import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    
        int n = id_list.length; //입력 배열의 길이
        int[] answer = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(id_list[i], i);
        }
        
        int[][] arr = new int[n][n];
        
        for (String re : report) {
            String[] s = re.split(" ");
            int x = map.get(s[0]), y = map.get(s[1]);
            if (x != y && arr[x][y] == 0) arr[x][y] = 1;  // ✅ 중복 방지
        }

        boolean[] resultArr = new boolean[n];
        for(int i=0;i<n;i++) {
            int x = 0;
            for(int j=0;j<n;j++) {
                x += arr[j][i];
            }
            if(x >= k) {
                resultArr[i] = true;
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) {continue;}
                if(arr[i][j] == 1 && resultArr[j]) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}

/*
1. 각 유저는 한 번에 한 명의 유저를 신고할 수 있다.
2. 한 유저를 여러 번 신고 가능. but, 동일 유저에 대한 신고 횟수는 1회로 처리
3. k번 이상 신고된 유저는 게시판 이용 정지. 해당 유저를 신고한 모든 유저에게 정지 사실을 발송
*/