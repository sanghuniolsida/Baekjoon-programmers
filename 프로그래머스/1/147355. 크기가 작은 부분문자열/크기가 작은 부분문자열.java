class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pt_length = t.length() - p.length();
        for(int i = 0; i <= pt_length; i++) {
            String str = t.substring(i, p.length() + i);
            if(Long.parseLong(str) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}
