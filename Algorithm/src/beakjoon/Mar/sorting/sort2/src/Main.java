import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = new int[size];
        //int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            try {
                arr[i] = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*count sort
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }*/
        Main obj = new Main();
        //obj.MergeSort(arr, temp, 0, size-1);
        //obj.CountSort(br, size);
        obj.QuickSort(arr, 0, size-1);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int result : arr){
            try {
                bufferedWriter.write(result + "\n");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void MergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            MergeSort(arr, temp, start, mid);
            MergeSort(arr, temp, mid + 1, end);
            Merge(arr, temp, start, mid, end);
        }
    }

    public void Merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int left = start;
        int right = mid + 1;
        int temp_cur = start;
        while (left <= mid && right <= end) {
            if (temp[left] <= temp[right]) {
                arr[temp_cur] = temp[left];
                left++;
            } else {
                arr[temp_cur] = temp[right];
                right++;
            }
            temp_cur++;
        }
        for (int i = 0; i <= mid - left; i++) {//앞쪽배열 남아있을 경우
            arr[temp_cur + i] = temp[left + i];
        }
    }

    public void CountSort(BufferedReader br, int size) {
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

    public void QuickSort(int[] arr, int start, int end) {
        int left_cur = start;
        int right_cur = end;
        int mid = (start+end)/2;
        int pivot = arr[mid];

        do{
            while (arr[left_cur] < pivot) left_cur++;
            while (arr[right_cur] > pivot) right_cur--;
            if (left_cur <= right_cur){
                int temp = arr[left_cur];
                arr[left_cur] = arr[right_cur];
                arr[right_cur] = temp;
                left_cur++;
                right_cur--;
            }
        }while (left_cur <= right_cur);

        if (start < right_cur) QuickSort(arr, start, right_cur);
        if (end > left_cur) QuickSort(arr, left_cur, end);

    }
}
