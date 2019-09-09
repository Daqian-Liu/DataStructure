package sort;

import queue.MyQueue;

import java.util.Arrays;

/**
 * @program: DataStructure->RadixQueueSort
 * @description: 基数排序 队列实现
 * @author: daqianliu
 * @create: 2019-09-09 21:46
 **/
public class RadixQueueSort {
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
        //用于临时存储数据的队列
        MyQueue[] temp = new MyQueue[10];
        //为队列数组赋值
        for (int i = 0;i<temp.length;i++){
            temp[i] = new MyQueue();
        }
        //根据最大长度的数决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //计算余数
                int ys = arr[j] / n % 10;
                //把当前遍历的数据放入指定的队列中
                temp[ys].add(arr[j]);
            }
            int index = 0;
            //把所有队列中的数字取出来
            for (int j = 0; j < temp.length; j++) {
                //当前遍历的队列不为空
                while (!temp[j].isEmpty()) {
                    arr[index] = temp[j].poll();
                    //记录下一个位置
                    index++;
                }
            }
        }
    }
}
