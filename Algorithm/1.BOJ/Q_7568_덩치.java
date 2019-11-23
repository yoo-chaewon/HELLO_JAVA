import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;

//덩치
public class Q_7568 {
    static int N = 50;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[N+1][2];

        for (int i = 0; i < num; i++){
            String[] input = bufferedReader.readLine().split(" ");
            int height = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);
            arr[i][0] = height;
            arr[i][1] = weight;
        }

        int[] rank = new int[N+1];
        for (int i = 0; i < N+1; i++){
            rank[i] = 1;
        }
        for (int i = 0; i < num-1; i++){
            for (int j = i+1; j < num; j++ ) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank[i]++;
                }else if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]){
                    rank[j]++;
                }
            }
        }

        for (int i = 0 ; i < num; i++){
            System.out.print(rank[i] + " ");
        }
    }
}
