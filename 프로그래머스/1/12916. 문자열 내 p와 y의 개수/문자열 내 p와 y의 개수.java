class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'p') {
                cnt1++;
            } else if(s.charAt(i) == 'y') {
                cnt2++;
            }
        }
        if(cnt1 == cnt2) {
            answer = true;
        } else if(cnt1 != cnt2) {
            answer = false;
        } else {
            answer = true;
        }
        return answer;
    }
}