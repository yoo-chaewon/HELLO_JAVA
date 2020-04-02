import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = i;
        boolean[] visited = new boolean[N+1];
        Permutation(arr, visited, 0, "");
    }

    public static void Permutation(int[] arr, boolean[] visited, int depth, String result){
        if (depth == arr.length-1){
            System.out.println(result);
            return;
        }

        for (int i = 1; i < arr.length; i++){
            if (!visited[i]){
                visited[i] = true;
                Permutation(arr, visited, depth+1, result+arr[i]+" ");
                visited[i] = false;
            }
        }
    }
}


