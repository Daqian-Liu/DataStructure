package tree;

/**
 * @program: DataStructure->TestBinarySortTree
 * @description:
 * @author: daqianliu
 * @create: 2019-09-14 14:16
 **/
public class TestBalancedBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{8,9,5,4,6,7};
        //创建一颗二叉排序树
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        //循环添加
        for(int i:arr){
            balancedBinaryTree.add(new BalancedTreeNode(i));
        }

        //查看高度
        System.out.println(balancedBinaryTree.root.height());
    }
}
