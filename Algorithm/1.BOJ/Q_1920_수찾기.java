import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++){
            hashSet.add(Integer.parseInt(str.nextToken()));
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        str = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++){
            int cur = Integer.parseInt(str.nextToken());
            if (hashSet.contains(cur)) System.out.println(1);
            else System.out.println(0);
        }
    }
}