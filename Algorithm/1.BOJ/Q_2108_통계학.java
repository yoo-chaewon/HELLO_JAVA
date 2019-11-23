import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    public static void main(String[] args){

    }
    //2108
    public static void Statistics() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int size = 0;
        int sum = 0;//산술 평균
        try {
            size = Integer.parseInt(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            try {
                arr.add(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //산술평균
        for (int i = 0; i < size; i++){
            sum += arr.get(i);
        }
        int avg = (int)Math.round(sum*1.0/size);
        System.out.println(avg);

        //중앙값
        Collections.sort(arr);
        int mid = (size-1) /2;
        System.out.println(arr.get(mid));

        //최빈값
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++){
            if (map.containsKey(arr.get(i))) {//키가 있으면
                map.put(arr.get(i), map.get(arr.get(i)).intValue() + 1);
            }
            else {//키가 없으면
                map.put(arr.get(i), 1);
            }
        }
        int max_value = map.get(arr.get(0)); //arr.get(0)번의 count된 값
        for (int i = 0; i < arr.size(); i++) {
            if (map.get(arr.get(i)) > max_value){
                max_value = map.get(arr.get(i));
            }
        }

        ArrayList<Integer> min_arr = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> i: map.entrySet()){
            if (i.getValue() == max_value) {
                min_arr.add(i.getKey());
            }
        }
        //System.out.println(min_arr);
        Collections.sort(min_arr);
        if (min_arr.size() == 1){
            System.out.println(min_arr.get(0));
        }else{
            System.out.println(min_arr.get(1));
        }
        map.clear();
        //범위
        int min = arr.get(0);
        int max = arr.get(size-1);
        System.out.println(max-min);
    }
}
