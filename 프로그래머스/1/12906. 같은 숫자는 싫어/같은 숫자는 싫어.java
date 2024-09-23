import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(st.peek() != arr[i]) {
                st.push(arr[i]);
            }
        }
        int[] answer = new int[st.size()];
        int[] arr4 = new int[st.size()];
        for(int i=0;i<arr4.length;i++) {
            arr4[i] = st.pop();
        }
        int index = 0;
        for(int i=answer.length-1;i>=0;i--) {
            answer[index] = arr4[i];
            index++;
        }
        return answer;
    }
}