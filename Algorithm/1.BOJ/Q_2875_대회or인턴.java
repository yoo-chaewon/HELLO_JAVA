import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(input[0]);//여
        int M = Integer.parseInt(input[1]);//남
        int K = Integer.parseInt(input[2]);//인턴

        int team = N/2;
        if( M < team )
            team = M;

        int others = N - (team*2) + (M-team);
        while (others < K){
            team--;
            others += 3;
        }

        System.out.println(team);
    }
}


