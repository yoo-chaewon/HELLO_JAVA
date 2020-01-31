import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            map[i][0] = Integer.parseInt(input[0]);
            map[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        for (int [] arr: map){
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
