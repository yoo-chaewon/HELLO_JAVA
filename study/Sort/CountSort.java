import java.io.*;
import java.util.ArrayList;

public class CountSort {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        CountSort(br, size);
    }

    public static void CountSort(BufferedReader br, int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            try {
                arr.add(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int max = arr.get(0);
        for (int i = 0; i < size; i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        int[] index = new int[max + 1];
        for (int i = 0; i < index.length; i++) {
            index[i] = 0;
        }
        for (int i = 0; i < arr.size(); i++) {
            int count = 0;
            if (index[arr.get(i)] == 0) {
                count++;
                index[arr.get(i)] = count;
            } else {
                index[arr.get(i)] += 1;
            }
        }
        for (int i = 0; i < index.length - 1; i++) {
            index[i + 1] += index[i];
        }
        int[] place = new int[arr.size() + 1];
        for (int i = 0; i < arr.size(); i++) {
            place[index[arr.get(i)] - 1] = arr.get(i);
            index[arr.get(i)] -= 1;
        }
        for (int i = 0; i < place.length - 1; i++) {
            System.out.println(place[i]);
        }
    }
}
