class Solution {
    public boolean solution(String s) {

        if(s.length() != 4 && s.length() != 6) return false;

        s = s.replaceAll("[0-9]","");

        return (s.length() > 0)?false:true;
    }
}