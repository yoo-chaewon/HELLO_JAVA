class Solution {
    int answer = 0;
    int mtarget = 0;

    public int solution(int[] numbers, int target) {
        mtarget = target;
        DFS(0, 0, numbers, 0);

        return answer;
    }

    public void DFS(int start, int depth, int[] numbers, int result) {
        if (depth == numbers.length) {
            if (result == mtarget) {
                answer++;
            }
        }

        for (int i = start; i < numbers.length; i++) {
            DFS(i + 1, depth + 1, numbers, result + numbers[i]);
            DFS(i + 1, depth + 1, numbers, result - numbers[i]);
        }
    }
}