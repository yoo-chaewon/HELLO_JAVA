import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            String[] NM = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(NM[0]); //문서수
            int M = Integer.parseInt(NM[1]); //문서 결과 찾아야 하는

            LinkedList<Integer> list = new LinkedList<>();
            int[] priority = new int[N];
            String[] input = bufferedReader.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                list.offer(Integer.parseInt(input[i]));
                priority[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(priority);
            int cur = N - 1;
            int answer = 0;

            while (!list.isEmpty()) {
                int temp = list.poll();
                if (temp != priority[cur]) {
                    list.offer(temp);
                    M = (M == 0) ? list.size() - 1 : --M;
                } else {
                    cur--;
                    answer++;
                    if (M == 0) {
                        System.out.println(answer);
                        break;
                    } else {
                        M--;
                    }
                }
            }
        }
    }
}