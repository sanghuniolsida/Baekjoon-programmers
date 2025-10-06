import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LinkedList<Integer> answer = new LinkedList<>();
        String[] strToday = today.split("\\.");
        int yToday = Integer.parseInt(strToday[0]);
        int mToday = Integer.parseInt(strToday[1]);
        int dToday = Integer.parseInt(strToday[2]);
        int todayDays = (yToday * 12 + mToday) * 28 + dToday;   

        Map<String, Integer> termMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] strTerms = terms[i].split(" ");
            termMap.put(strTerms[0], Integer.parseInt(strTerms[1]));
        }

        for (int j = 0; j < privacies.length; j++) {
            String[] arr = privacies[j].split(" ");          
            String[] arr2 = arr[0].split("\\.");            
            int year = Integer.parseInt(arr2[0]);
            int month = Integer.parseInt(arr2[1]);
            int day = Integer.parseInt(arr2[2]);
            String code = arr[1];

            int startDays = (year * 12 + month) * 28 + day;
            int months = termMap.get(code);                  
            int expiryDays = startDays + months * 28 - 1;    

            if (expiryDays < todayDays) {
                answer.add(j + 1);                          
            }
        }

        int[] res = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) res[i] = answer.get(i);
        return res;
    }
}
