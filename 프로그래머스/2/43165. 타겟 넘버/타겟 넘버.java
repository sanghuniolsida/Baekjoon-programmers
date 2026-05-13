class Solution {
    static int[] numbers;
    static int target;
    static int answer;
    
    void dfs(int index, int sum) {
        //탈출 조건
        if(index == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        //재귀 콜
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);
    }
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        
        dfs(0,0);
        return answer;
    }
}