public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }

    static int answer = Integer.MAX_VALUE;
    public static int solution(int N, int number) {
        int size = N <= 2 ? 5 : 4;
        int[] map = new int[size];
        int myN = N;
        for (int i = 0; i < size; i++){
            map[i] = myN;
            myN = 10 * myN + N;
        }
        DFS(map, number, 0, 0, 0);
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

    public static void DFS(int[] arr, int number, int depth, int result, int nCount){
        if (nCount > 8)  return;

        if (number == result){
            answer = Math.min(answer, nCount);
            return;
        }

        for (int i = 0; i < arr.length; i++){
            DFS(arr, number, depth+1, result + arr[i], nCount + i+1);
            DFS(arr, number, depth+1, result - arr[i], nCount + i+1);
            DFS(arr, number, depth+1, result * arr[i], nCount + i+1);
            DFS(arr, number, depth+1, result / arr[i], nCount + i+1);
        }
    }
}
