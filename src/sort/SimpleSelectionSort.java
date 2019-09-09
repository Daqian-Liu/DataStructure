package sort;

import java.util.Arrays;

/**
 * @program: DataStructure->SimpleSelectionSort
 * @description: 简单选择排序
 * @author: daqianliu
 * @create: 2019-09-09 18:26
 **/
public class SimpleSelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0, 9, 1};
        simpleSelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void simpleSelectionSort(int[] arr) {
        //遍历所有数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //把当前遍历的数组和后面所有的数依次进行比较，并记录下最小数的下标
            for (int j = i + 1; j < arr.length; j++) {
                //如果后面比较的数比记录的最小的数小
                if (arr[j] < arr[minIndex]) {
                    //记录下最小的那个数的下标
                    minIndex = j;
                }
            }
            //如果最小的数和当前遍历数的下标不一致，说明下标为minIndex的数比当前遍历的数更小
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
