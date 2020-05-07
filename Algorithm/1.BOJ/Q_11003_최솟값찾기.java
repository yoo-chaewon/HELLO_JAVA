import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int[] map = new int[N];
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(str.nextToken());
        }
        Deque<Point> pointDeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            while (!pointDeque.isEmpty() && pointDeque.peekLast().value > map[i]) {
                pointDeque.pollLast();
            }
            pointDeque.addLast(new Point(map[i], i));
            while (pointDeque.peekFirst().index + L <= i) {
                pointDeque.pollFirst();
            }
            bufferedWriter.write(pointDeque.peekFirst().value + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

class Point {
    int value, index;

    Point(int value, int index) {
        this.value = value;
        this.index = index;
    }
}