import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_3085 {
    static int size = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++){
            String temp = bufferedReader.readLine();
            for (int j = 0; j < size; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        CandyGame(map);
    }
    public static void CandyGame(char[][] map){
        int count = 1;
        int max = 1;
        char cur = 'f';
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (cur == map[i][j]){
                    count++;
                }else{
                    if (count > 1){

                    }
                    max = Math.max(max, count);
                    count = 1;
                    cur = map[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
