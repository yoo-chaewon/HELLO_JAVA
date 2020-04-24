import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] ground;
    static int[][] machine;
    static PriorityQueue<Tree> treeQueue = new PriorityQueue<>(new Comparator<Tree>() {
        @Override
        public int compare(Tree o1, Tree o2) {
            return o1.size - o2.size;
        }
    });
    static Queue<Tree> live = new LinkedList<>();
    static Queue<Tree> death = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());

        ground = new int[N][N];
        machine = new int[N][N];
        for (int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++){
                machine[i][j] = Integer.parseInt(str.nextToken());
                ground[i][j] = 5;
            }
        }

        while (M-- >0){
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            int y = Integer.parseInt(str.nextToken())-1;
            int x = Integer.parseInt(str.nextToken())-1;
            treeQueue.add(new Tree(x, y, Integer.parseInt(str.nextToken())));
        }

        while (K-->0) Year();
        System.out.println(treeQueue.size());
    }

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0 , 1, 1, 1, 0, -1, -1};
    public static void Year(){
        //봄
        while (!treeQueue.isEmpty()){
            Tree cur = treeQueue.poll();
            if (ground[cur.y][cur.x] >= cur.size) {
                ground[cur.y][cur.x] -= cur.size;
                live.add(new Tree(cur.x, cur.y, cur.size + 1));
            }else death.add(cur);
        }

        //여름
        while (!death.isEmpty()){
            Tree cur = death.poll();
            ground[cur.y][cur.x] += cur.size/2;
        }

        //가을
        while (!live.isEmpty()){
            Tree cur = live.poll();
            treeQueue.add(cur);
            if (cur.size % 5 == 0){
                for (int i = 0; i < 8; i++){
                    int nextX = cur.x + dx[i];
                    int nextY = cur.y + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                    treeQueue.add(new Tree(nextX, nextY, 1));
                }
            }
        }

        //겨울
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                ground[i][j] += machine[i][j];
            }
        }
    }
}

class Tree{
    int x, y, size;
    Tree(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
}