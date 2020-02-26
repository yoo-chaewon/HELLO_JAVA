public class Main {
    public static void main(String[] args) {
        int arr1[] = {2, 5, 3, 8, 1};
        int arr2[] = {1, 1, 2, 2};
        int arr3[] = {1, 2, 3, 2};

        System.out.println(Solution.solution(arr1, 3, 11));
        System.out.println(Solution.solution(arr2, 2, 3));
        System.out.println(Solution.solution(arr3, 2, 2));
    }
}

class Solution {
    static int answer;
    public static int solution(int[] arr, int k, int t) {
        answer = 0;
        DFS(arr, 0, 0, "", k, t);
        return answer;
    }

    public static void DFS(int[] arr, int start, int depth, String result, int k, int t) {
        if (depth >= k) {
            int sum = 0;
            for (int i = 0; i < result.length(); i++){
                sum += result.charAt(i)-'0';
            }
            if (sum <= t) answer++;
        }
        for (int i = start; i < arr.length; i++) {
            DFS(arr, i + 1, depth + 1, result + arr[i], k, t);
        }
    }
}