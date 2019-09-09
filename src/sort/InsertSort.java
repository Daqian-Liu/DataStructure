package sort;

import java.util.Arrays;

/**
 * @program: DataStructure->InsertSort
 * @description: 直接插入排序
 * @author: daqianliu
 * @create: 2019-09-09 16:15
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0, 9, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //如果他比前一个小
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
