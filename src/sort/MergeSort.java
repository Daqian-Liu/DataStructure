package sort;

import java.util.Arrays;

/**
 * @program: DataStructure->MergeSort
 * @description: 归并排序
 * @author: daqianliu
 * @create: 2019-09-09 20:06
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0, 9, 1};
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high) {
        //用于存储归并后的临时数组
        int[] temp = new int[high - low + 1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        //记录第二个数组中需要遍历的下标
        int j = middle + 1;
        int index = 0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i <= middle && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        //处理多余数组
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }
}
