import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        Arrays.sort(arr);
        String str = String.valueOf(arr[arr.length - 1]);
        for(int i=arr.length -2;i>=0;i--) {
            str += String.valueOf(arr[i]);
        }
        answer = Long.parseLong(str);
        return answer;
    }
}