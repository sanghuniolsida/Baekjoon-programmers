class Solution {
    public double solution(double n) {
        double sqrt = Math.sqrt(n);
        
        if (sqrt == (int)sqrt) {
            long answer = (long)Math.pow(sqrt + 1, 2);
            return answer;
        }
        
        return -1;
    }
}
