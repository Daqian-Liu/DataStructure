package Recursive;

/**
 * @program: DataStructure->Febonacci
 * @description: 斐波那契数列
 * @author: daqianliu
 * @create: 2019-09-09 09:40
 **/
public class Febonacci {
    public static void main(String[] args) {
        System.out.println(febonacci(7));
    }

    public static int febonacci(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return febonacci(i-1)+febonacci(i-2);
        }
    }
}
