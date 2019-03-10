## **정렬**

#### 선택정렬

첫 번째 자료를 두번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 첫 번째에 놓고, 두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여 그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행한다. 1회전을 수행하고 나면 가장 작은 값의 자료가 맨 앞에 오게 되므로 그 다음 회전에서는 두 번째 자료를 갖고 비교한다.

```java
public int[] SelectSort(int count, int[] arr){
    int cur_x = 0;
    int cur_m = cur_x + 1;
    int temp;

    for (int i = 0; i < count; i++){
        for (int j = i+1 ; j < count; j++){
            if (arr[i] > arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}
```



#### 버블정렬

첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를,.. 이런 식으로 (마지막 -1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬한다. 1회전을 수행하고 나면 가장 큰 자료가 맨 뒤로 이동하고 2회전에서는 맨 끝네 있는 자료는 정렬에서 제외되고, 2회전을 수행하고 나면 끝에서 두 번째 자료까지는 정렬에서 제외된다. 이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다. 

```java
public int[] BubbleSort(int count, int[] arr) {
    int temp;

    for (int i = 1; i < count; i++) {
        for (int j = 0; j < count - i; j++) {
            if (arr[j] > arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    return arr;
}
```



#### 삽입정렬

두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입 할 위치를 지정한 후 자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘이다. 즉, 두 번째 자료는 첫 번째 자료, 세 번째 자료는 두 번째 자료와 첫 번째 자료, 네 번째 자료는 세 번째, 두 번째, 첫 번째 자료와 비료한 후 자료가 삽입 될 위치를 찾는다. 자료가 삽입될 위치를 찾았다면 그 위치에 자료를 삽입하기 위해 자료를 한 칸씩 뒤로 이동시킨다.

```java
public int[] InsertSort(int count, int[] arr){
    int key;
    for (int i = 1 ; i < count ; i++){
        key = arr[i];
        for (int j = i-1; j >= 0; j--){
            if (arr[j] > key){
                arr[j+1] = arr[j];
                arr[j] = key;
            }
            else break;
        }
    }
    return  arr;
}
```