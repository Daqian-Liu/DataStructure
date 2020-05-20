package tree;

/**
 * @program: DataStructure->BinaryTree
 * @description: 二叉树
 * @author: daqianliu
 * @create: 2019-09-12 12:57
 **/
public class BinaryTree {

    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void frontShow(){
        root.frontShow();
    }

    public void middleShow(){
        root.middleShow();
    }

    public void afterShow() {
        root.afterShow();
    }

    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if (root.value==i){
            root = null;
        }else {
            root.delete(i);
        }
    }
}
