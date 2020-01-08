import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);//멀티탭구멍수
        int K = Integer.parseInt(input[1]);//사용횟수
        int[] arr = new int[K];
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> multi = new HashSet<>();
        int answer = 0;

        String[] str = bufferedReader.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(str[i]);
            arrayList.add(Integer.parseInt(str[i]));
        }

        for (int i = 0; i < K; i++) {
            if (multi.contains(arr[i]) || multi.size() < N) {
                multi.add(arr[i]);
            } else {
                answer++;
                int index = Integer.MIN_VALUE;

                for (int cur : multi) {
                    if (arrayList.subList(i + 1, K).contains(cur)) {
                        int position = arrayList.subList(i + 1, K).indexOf(cur) + i + 1;
                        index = Math.max(position, index);
                    } else {
                        multi.remove(cur);
                        break;
                    }
                }
                if (multi.size() == N) {
                    multi.remove(arr[index]);
                }
                multi.add(arr[i]);
            }
        }
        System.out.println(answer);
    }
}
