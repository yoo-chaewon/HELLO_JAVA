import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bufferedReader.readLine().split(" ");
        int broken = Integer.parseInt(str[0]);
        int kinds = Integer.parseInt(str[1]);
        int min = Integer.MAX_VALUE;
        int set = 1000;
        int per = 1000;

        for (int i = 0; i < kinds; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            set = Math.min(set, Integer.parseInt(input[0]));
            per = Math.min(per, Integer.parseInt(input[1]));
        }

        if (per * 6 < set) min = Math.min(min, broken / 6 * per * 6);
        else min = Math.min(min, broken / 6 * set);

        broken %= 6;

        if (set < broken * per) min += set;
        else min += broken * per;
        System.out.println(min);
    }
}


