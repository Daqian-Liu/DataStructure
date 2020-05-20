package tree;

/**
 * @program: DataStructure->TestBinarySortTree
 * @description:
 * @author: daqianliu
 * @create: 2019-09-14 14:16
 **/
public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9};
        //创建一颗二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环添加
        for(int i:arr){
            binarySortTree.add(new TreeNode(i));
        }

        System.out.println(binarySortTree.search(10));
    }
}
