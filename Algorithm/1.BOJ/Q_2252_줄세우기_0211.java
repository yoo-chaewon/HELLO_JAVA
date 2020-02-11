import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] count = new int[N+1];
        ArrayList<Integer>[] arrayLists = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++){
            arrayLists[i] = new ArrayList<>();
        }

        while (M -- > 0){
            String[] input = bufferedReader.readLine().split(" ");
            arrayLists[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            count[Integer.parseInt(input[1])]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++){
            if (count[i] == 0) {
                queue.add(i);
                count[i]--;
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 0; i< arrayLists[cur].size(); i++){
                count[arrayLists[cur].get(i)]--;
                if (count[arrayLists[cur].get(i)] == 0)
                    queue.add(arrayLists[cur].get(i));
            }
        }
    }
}