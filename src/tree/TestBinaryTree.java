package tree;

/**
 * @program: DataStructure->TestBinaryTree
 * @description:
 * @author: daqianliu
 * @create: 2019-09-12 13:58
 **/
public class TestBinaryTree {
    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        binaryTree.setRoot(root);

        TreeNode rootR = new TreeNode(3);
        root.setrNode(rootR);

        TreeNode rootL = new TreeNode(2);
        root.setlNode(rootL);

        //第二层的左节点创建子节点
        rootL.setlNode(new TreeNode(4));
        rootL.setrNode(new TreeNode(5));

        //第二层的右节点创建子节点
        rootR.setlNode(new TreeNode(6));
        rootR.setrNode(new TreeNode(7));

        //前序遍历
        binaryTree.frontShow();
        System.out.println("===========================");

        //中序遍历
        binaryTree.middleShow();
        System.out.println("===========================");

        //后序遍历
        binaryTree.afterShow();
        System.out.println("===========================");

        //前序查找
        TreeNode result = binaryTree.frontSearch(1);
        System.out.println(result.value);
        System.out.println("===========================");

        //删除子树
        binaryTree.delete(3);
        binaryTree.frontShow();

    }
}
