package sort;

import java.util.Arrays;

/**
 * @program: DataStructure->QuickSort
 * @description: 快速排序
 * @author: daqianliu
 * @create: 2019-09-09 13:41
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,2,7,2,8,0,9,1};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick(int[] arr, int start, int end) {
        if (start < end) {
            //把数组的第0个数字作为标准数
            int standard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //右边的数比标准数大
                while (low < high && standard <= arr[high]) high--;
                //右边的数比标准数小
                arr[low]=arr[high];
                //左边的数比标准数小
                while (low<high&&standard>=arr[low]) low++;
                //左边的数比标准数大
                arr[high] = arr[low];
            }
            //把标准数赋给低所在位置的索引
            arr[low]=standard;
            //处理所有小的数字
            quick(arr,start,low);
            //处理所有大的数字
            quick(arr,low+1,end);
        }
    }
}
