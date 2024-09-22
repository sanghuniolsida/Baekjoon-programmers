class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        if(length % 2 == 0) {
            int num = length / 2;
            answer = s.substring(num-1,num+1);
            return answer;
        } else {
            int num = length / 2;
            answer = String.valueOf(s.charAt(num));
            return answer;
        }
    }
}