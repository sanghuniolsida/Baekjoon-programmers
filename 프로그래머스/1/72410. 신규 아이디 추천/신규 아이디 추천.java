import java.util.*;

class Solution {
    public String solution(String new_id) {
        List<String> list = new LinkedList<>();

        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isUpperCase(ch)) ch = Character.toLowerCase(ch);

            if (Character.isLowerCase(ch) || Character.isDigit(ch) ||
                ch == '-' || ch == '_' || ch == '.') {
                list.add(String.valueOf(ch));
            }
        }

        for (int i = 1; i < list.size(); ) {
            if (list.get(i).equals(".") && list.get(i - 1).equals(".")) {
                list.remove(i);
            } else {
                i++;
            }
        }

        while (!list.isEmpty() && list.get(0).equals(".")) list.remove(0);
        while (!list.isEmpty() && list.get(list.size() - 1).equals(".")) list.remove(list.size() - 1);

        if (list.isEmpty()) list.add("a");

        if (list.size() > 15) {
            list = new LinkedList<>(list.subList(0, 15));
            while (!list.isEmpty() && list.get(list.size() - 1).equals(".")) {
                list.remove(list.size() - 1);
            }
        }

        while (list.size() < 3) {
            list.add(list.get(list.size() - 1));
        }

        return String.join("", list);
    }
}
