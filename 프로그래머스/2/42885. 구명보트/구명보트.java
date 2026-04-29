import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0 ; //가벼운 사람
        int right = people.length-1; //가장 무거운 사람
        Arrays.sort(people);
        
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
        }
        return answer;
    }
}