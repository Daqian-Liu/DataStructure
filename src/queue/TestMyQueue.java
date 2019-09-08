package queue;

/**
 * @program: DataStructure->TestMyQueue
 * @description:
 * @author: daqianliu
 * @create: 2019-09-08 16:07
 **/
public class TestMyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(9);
        queue.add(8);
        queue.add(7);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
