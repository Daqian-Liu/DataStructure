package sort;

/**
 * @program: DataStructure->BubbleSort
 * @description: 冒泡排序
 * @author: daqianliu
 * @create: 2019-09-09 13:12
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5,7,2,9,4,1,0,5,7};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
