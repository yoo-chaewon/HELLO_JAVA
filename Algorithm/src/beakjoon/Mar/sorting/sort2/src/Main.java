import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Main obj = new Main();
        //obj.MergeSort(arr, temp, 0, size-1);
        obj.CountSort();

        for (int i = 0; i < size; i++){
            System.out.println(arr[i]);
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
        for (int i = start; i <= end; i++){
            temp[i] = arr[i];
        }
        int left = start;
        int right = mid+1;
        int temp_cur = start;
        while (left <= mid && right <= end){
            if (temp[left] <= temp[right]){
                arr[temp_cur] = temp[left];
                left++;
            }else{
                arr[temp_cur] = temp[right];
                right++;
            }
            temp_cur++;
        }
        for (int i = 0; i <= mid-left; i++){//앞쪽배열 남아있을 경우
            arr[temp_cur+i] = temp[left+i];
        }
    }

    public void CountSort(){

    }
}
