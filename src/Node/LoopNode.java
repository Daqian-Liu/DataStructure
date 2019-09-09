package Node;

/**
 * @program: DataStructure->Node
 * @description:
 * @author: daqianliu
 * @create: 2019-09-08 16:11
 **/
public class LoopNode {
    public static void main(String[] args) {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        //增加节点
        n1.after(n2);
        n2.after(n3);
        System.out.println(n1.next.data);
        System.out.println(n2.next.data);
        System.out.println(n3.next.data);
    }
    //节点内容
    int data;

    //下个节点
    LoopNode next=this;

    public LoopNode(int data) {
        this.data = data;
    }


    //获取下一个节点
    public LoopNode next(){
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
        LoopNode newNext = next.next;
        this.next=newNext;
    }


    //插入一个节点，作为当前节点的下一个节点
    public void after(LoopNode node){
        //取出下一个节点，作为下下一个节点
        LoopNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next = nextNext;
    }
}
