import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<priorities.length;i++) {
            q.offer(new int[] {i, priorities[i]}); //여기서 i는 location
            pq.offer(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cur = current[0];
            int priori = current[1];
            
            if(priori < pq.peek()) {
                q.offer(current);
            } else {
                pq.poll();
                answer++;
                
                if(location == cur) {
                    return answer;
                }
            }
        }
        return answer;
    }
}