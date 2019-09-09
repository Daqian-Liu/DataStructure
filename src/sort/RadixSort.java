package sort;

import java.util.Arrays;

/**
 * @program: DataStructure->RadixSort
 * @description: 基数排序
 * @author: daqianliu
 * @create: 2019-09-09 21:46
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 6, 189, 45, 9, 287, 56, 1, 798, 34, 65, 652, 5};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //存数组中最大的数字
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算最大数字是几位数
        int maxLength = (max + "").length();
        //用于临时存储数据的数组
        int[][] temp = new int[10][arr.length];
        //用于记录在temp中相应的数组中存放的数字的数量
        int[] counts = new int[10];
        //根据最大长度的数决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //计算余数
                int ys = arr[j] / n % 10;
                temp[ys][counts[ys]] = arr[j];
                counts[ys]++;
            }
            int index = 0;
            //把数字取出来
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] != 0) {
                    for (int k = 0; k < counts[j]; k++) {
                        arr[index] = temp[j][k];
                        index++;
                    }
                    //把数量置空
                    counts[j] = 0;
                }
            }
        }
    }
}
