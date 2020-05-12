import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());

        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < size; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        Go(0, map);
        System.out.println(result);
    }

    static int result = 0;
    public static void Go(int depth, int[][] map){
        if (depth == 5){
            result = Math.max(result, FindMax(map));
            return;
        }

        for (int dir = 0; dir < 4; dir++){
            int[][] newMap = Move(dir, map);
            Go(depth+1, newMap);
        }
    }

    public static int[][] Move(int dir, int[][] map){
        int[][] newMap = new int[map.length][map.length];
        ArrayList<Integer> getValue = new ArrayList<>();
        ArrayList<Integer> resultValue = new ArrayList<>();
        for (int i = 0; i < map.length; i++){
            getValue.clear();
            resultValue.clear();
            for (int j = 0; j < map.length; j++){
                if (dir == 0 || dir == 1){//up, down
                    if (map[j][i] != 0)getValue.add(map[j][i]);
                }else {//left, right
                    if (map[i][j] != 0)getValue.add(map[i][j]);
                }
            }
            if (dir == 1 || dir == 3) Collections.reverse(getValue);
            for (int j = 0; j < getValue.size(); j++){
                if (j!= getValue.size()-1 && getValue.get(j).equals(getValue.get(j+1))){
                    resultValue.add(getValue.get(j)*2);
                    j++;
                }else {
                    resultValue.add(getValue.get(j));
                }
            }

            for (int j = 0; j < resultValue.size(); j++){
                if (dir == 0) newMap[j][i] = resultValue.get(j);
                else if (dir == 1)newMap[map.length-1-j][i] = resultValue.get(j);
                else if (dir == 2)newMap[i][j] = resultValue.get(j);
                else if (dir == 3)newMap[i][map.length-1-j] = resultValue.get(j);
            }
        }
        return newMap;
    }

    public static int FindMax(int[][] map){
        int max = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
}