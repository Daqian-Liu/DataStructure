package Node;

import java.util.Scanner;

/**
 * @program: DataStructure->Node
 * @description:
 * @author: daqianliu
 * @create: 2019-09-08 16:11
 **/
public class Node {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        //追加节点
        n1.append(n2);
        n1.append(n3);
        n1.show();
    }
    //节点内容
    int data;

    //下个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //为节点追加节点
    public Node append(Node node) {
        //当前节点
        Node currentNode = this;
        //循环向后找
        while (true){
            //取出下一个节点
            Node nextNode  = currentNode.next;
            //如果下一个节点为null，当前节点已经是最后一个节点
            if (nextNode==null){
                break;
            }
            //赋给当前节点
            currentNode = nextNode;
        }
        //把需要追加的节点追加为找到的结点的下一个节点
        currentNode.next=node;
        return node;
    }

    //获取下一个节点
    public Node next(){
        return this.next;
    }

    //获取节点中的数据
    public int getData(){
        return this.data;
    }

    //当前节点是否是最后一个节点
    public boolean isLast(){
        return next==null;
    }

    //删除下一个节点
    public void removeNext(){
        Node newNext = next.next;
        this.next=newNext;
    }

    //显示所有节点信息
    public void show(){
        Node currentNode = this;
        while (true){
            System.out.println(currentNode.data+ " ");
            currentNode = currentNode.next;
            if (currentNode==null) break;
        }
    }

    //插入一个节点，作为当前节点的下一个节点
    public void after(Node node){
        //取出下一个节点，作为下下一个节点
        Node nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next = nextNext;
    }
}
