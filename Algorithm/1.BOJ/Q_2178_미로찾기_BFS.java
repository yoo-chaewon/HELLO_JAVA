package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178_BFS {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());//세로
        int M = Integer.parseInt(st.nextToken());//가로
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i <N; i++){
            String[] data = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        Queue<Point_BFS> queue = new LinkedList<Point_BFS>();
        queue.add(new Point_BFS(0,0));
        visited[0][0] = 1;
        while (queue.isEmpty() == false){
            Point_BFS point = queue.poll();
            for (int i = 0; i < 4; i++){
                int nextX = point.px + dx[i];
                int nextY = point.py + dy[i];
                if (nextX < 0|| nextY <0|| nextX >= M|| nextY >= N){
                    continue;
                }
                if (map[nextY][nextX] == 0 || visited[nextY][nextX] == 1){
                    continue;
                }
                map[nextY][nextX] = map[point.py][point.px] + 1;
                visited[nextY][nextX] = 1;
                if ((nextY==N-1)&&(nextX==M-1)){
                    System.out.println(map[nextY][nextX]);
                    return;
                }
                queue.add(new Point_BFS(nextX, nextY));
            }
        }
    }
}
class Point_BFS{
    int px;
    int py;
    Point_BFS(int px, int py){
        this.px = px;
        this.py = py;
    }
}
