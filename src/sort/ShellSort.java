package sort;

import java.util.Arrays;

/**
 * @program: DataStructure->ShellSort
 * @description: 希尔排序
 * @author: daqianliu
 * @create: 2019-09-09 16:50
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0, 9, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        //遍历所有步长
        for (int d = arr.length / 2; d > 0; d /= 2) {
            //遍历所有元素
            for (int i = d; i < arr.length; i++) {
                //遍历本组所有的元素
                for (int j = i - d; j >= 0; j -= d) {
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j + d];
                        arr[j + d] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
