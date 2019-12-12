import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int loop = scanner.nextInt();

        for (int k = 0; k < loop; k++){
            int count = scanner.nextInt();
            int[][] arr = new int[count][2];
            int answer = 1;

            for (int i = 0; i < count; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int cur = arr[0][1];

            for (int i = 1; i < count; i++){
                if (arr[i][1] < cur){
                    answer++;
                    cur = arr[i][1];

                }
            }
            System.out.println(answer);
        }
    }
}


