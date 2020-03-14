class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target,0, 0);
        return answer;
    }

    public void DFS(int[] numbers, int target, int sum, int index){
        if (index == numbers.length){
            if (target == sum) answer++;
            return;
        }
        DFS(numbers, target, sum + numbers[index], index+1);
        DFS(numbers, target, sum - numbers[index], index+1);
    }
}