import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int[][] arr = new int[N][2];
        int answer = 1;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < 2; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        int end = arr[0][1];
        for (int i = 1; i < N; i++){
            if ( end <= arr[i][0]){
                end = arr[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}


