class Solution {
    public long solution(long num) {
        int answer = 0;
        int cnt = 0;
        while(num != 1) {
            if(num % 2 == 0) {
                num = num/2;
                cnt++;
            } else if(num % 2 != 0) {
                num = num*3 + 1;
                cnt++;
            } 
        }
        if(cnt<500) {
            answer = cnt;
        } else {
            answer = -1;
        }
        
        return answer;
    }
}