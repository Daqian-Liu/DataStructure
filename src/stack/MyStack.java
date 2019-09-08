package stack;

/**
 * @program: DataStructure->stack.MyStack
 * @description:
 * @author: daqianliu
 * @create: 2019-09-08 14:16
 **/
public class MyStack {

    //栈的底层使用数组来存储数据
    int[] elements;

    public MyStack(){
        elements = new int[0];
    }

    //压入元素
    public void push(int element){
        //创建一个数组
        int[] newArr = new int[elements.length+1];
        //把原数组中的元素复制到新数组中
        for (int i = 0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
        //把新添加的元素放入数组中
        newArr[elements.length] = element;
        //使用新数组替换就数组
        elements = newArr;
    }

    //取出栈顶元素
    public int pop(){
        if (elements.length==0){
            throw new RuntimeException("stack is empty");
        }
        //取出数组的最后一个元素
        int element = elements[elements.length - 1];
        int[] newArr = new int[elements.length-1];
        for (int i = 0;i<newArr.length;i++){
            newArr[i] = elements[i];
        }
        //替换数组
        elements = newArr;
        //返回栈顶元素
        return element;
    }

    //查看栈顶元素
    public int peek(){
        if (elements.length==0){
            throw new RuntimeException("stack is empty");
        }
        return elements[elements.length-1];
    }
}
