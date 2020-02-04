import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int size;
    static String[] input;
    static ArrayList<String> resultArr = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        input = bufferedReader.readLine().split(" ");

        boolean[] visited = new boolean[10];

        String result = "";
        DFS(0, visited, result );
        Collections.sort(resultArr);
        System.out.println(resultArr.get(resultArr.size()-1));
        System.out.println(resultArr.get(0));
    }

    public static void DFS(int depth, boolean[] visited, String result){
        if (size+1 == depth){
            for (int i = 0; i < input.length; i++){
                if (input[i].equals("<")){
                    if (!(result.charAt(i) < result.charAt(i+1))) return;
                }else {
                    if (!(result.charAt(i) > result.charAt(i+1))) return;
                }
            }
            resultArr.add(result);
            return;
        }

        for (int i = 0; i <= 9; i++){
            if (!visited[i]){
                visited[i] = true;
                DFS(depth + 1, visited, result + i);
                visited[i] = false;
            }
        }
    }
}