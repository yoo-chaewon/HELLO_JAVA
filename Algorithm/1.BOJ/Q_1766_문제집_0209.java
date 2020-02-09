import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] count = new int[N+1];
        ArrayList<Integer>[] arrayList = new ArrayList[N+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N+1; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            arrayList[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            count[Integer.parseInt(input[1])]++;
        }

        for (int i = 1; i < N+1; i++){
            if (count[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 0; i < arrayList[cur].size(); i++){
                count[arrayList[cur].get(i)]--;
                if (count[arrayList[cur].get(i)] == 0){
                    queue.add(arrayList[cur].get(i));
                }
            }
        }
    }
}