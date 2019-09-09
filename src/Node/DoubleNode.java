package Node;

/**
 * @program: DataStructure->DoubleNode
 * @description:
 * @author: daqianliu
 * @create: 2019-09-09 09:17
 **/
public class DoubleNode {

    DoubleNode pre = this;
    DoubleNode next = this;
    int data;

    public DoubleNode(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        //创建节点
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);

        n1.after(n2);
        n1.after(n3);
        System.out.println(n1.getPre().getData());
        System.out.println(n1.getNext().getData());
        System.out.println(n1.getData());
        System.out.println(n3.getNext().getData());
    }

    //增加节点
    public void after(DoubleNode node) {
        //原来的下一个节点
        DoubleNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        node.pre = this;
        //让原来的下一个节点作为新节点的下一个节点
        node.next = nextNext;
        nextNext.pre = node;
    }

    //下一个节点
    public DoubleNode getNext() {
        return this.next;
    }

    //上一个节点
    public DoubleNode getPre() {
        return this.pre;
    }

    //获取数据
    public int getData(){
        return this.data;
    }
}
