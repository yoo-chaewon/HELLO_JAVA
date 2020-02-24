import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++){
            String result = String.valueOf(i);
            if (result.contains("3") || result.contains("6") || result.contains("9")){
                result = "";
                for (int j = 0; j < String.valueOf(i).length(); j++){
                    if (String.valueOf(i).charAt(j)=='3' || String.valueOf(i).charAt(j)=='6' || String.valueOf(i).charAt(j) == '9') result += "-";
                }
            }
            System.out.print(result + " ");
        }
    }
}
