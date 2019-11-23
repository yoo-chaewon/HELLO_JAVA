import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Q_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nine_arr = new ArrayList<>();
        int nine_sum = 0;
        int input;
        for (int i = 1; i < 10; i++){
            input = Integer.parseInt(bufferedReader.readLine());
            nine_arr.add(input);
            nine_sum += input;
        }
        for (int i = 0 ; i < nine_arr.size()-1; i++){
            for (int j = i+1; j < nine_arr.size(); j++){
                if((nine_sum - nine_arr.get(i) - nine_arr.get(j)==100)){
                    int x = nine_arr.get(i);
                    int y = nine_arr.get(j);
                    Collections.sort(nine_arr);
                    for (int a : nine_arr){
                        if ((a != x)&&(a != y))
                        System.out.println(a);
                    }
                    return;
                }
            }
        }
    }
}
