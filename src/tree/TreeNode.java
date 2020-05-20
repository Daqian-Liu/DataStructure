package tree;

/**
 * @program: DataStructure->TreeNode
 * @description:
 * @author: daqianliu
 * @create: 2019-09-12 13:55
 **/
public class TreeNode {
    int value;

    TreeNode lNode;
    TreeNode rNode;

    public TreeNode(int value) {
        this.value = value;
    }

    //设置左儿子
    public void setlNode(TreeNode lNode) {
        this.lNode = lNode;
    }

    //设置右儿子
    public void setrNode(TreeNode rNode) {
        this.rNode = rNode;
    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        System.out.println(value);
        if (lNode != null) {
            lNode.frontShow();
        }
        if (rNode != null) {
            rNode.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void middleShow() {
        if (lNode != null) {
            lNode.middleShow();
        }
        System.out.println(value);
        if (rNode != null) {
            rNode.middleShow();
        }
    }

    public void afterShow() {
        if (lNode != null) {
            lNode.afterShow();
        }
        if (rNode != null) {
            rNode.afterShow();
        }
        System.out.println(value);
    }

    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        if (this.value == i) {
            return this;
        } else {
            if (lNode != null) {
                target = lNode.frontSearch(i);
            }
            if (target != null) {
                return target;
            }
            if (rNode != null) {
                target = rNode.frontSearch(i);
            }
        }
        return target;
    }

    //删除一棵子树
    public void delete(int i) {
        TreeNode parent = this;
        //判断左儿子
        if (parent.lNode != null && parent.lNode.value == i) {
            parent.lNode = null;
            return;
        }
        //判断右儿子
        if (parent.rNode != null && parent.rNode.value == i) {
            parent.rNode = null;
            return;
        }

        //递归检查并删除左儿子
        parent = lNode;
        if (parent != null) {
            parent.delete(i);
        }
        //递归检查并删除右儿子
        parent = rNode;
        if (parent != null) {
            parent.delete(i);
        }

    }

    /**
     * 二叉排序树
     *
     * @param node
     */
    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值比当前子树的根节点的值大还是小
        if (node.value < this.value) {
            //添加的节点比当前节点的值更小
            //如果左节点为空
            if (this.lNode == null) {
                this.lNode = node;
            } else {
                //如果不为空
                this.lNode.add(node);
            }
        } else {
            if (this.rNode == null) {
                this.rNode = node;
            } else {
                this.rNode.add(node);
            }
        }
    }

    /**
     * 查找节点
     *
     * @param value
     */
    public TreeNode search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (lNode == null) {
                return null;
            }
            return lNode.search(value);
        } else {
            if (rNode == null) {
                return null;
            }
            return rNode.search(value);
        }
    }

    public TreeNode searchParent(int value) {
        if (this.lNode != null && this.lNode.value == value || this.rNode != null && this.rNode.value == value) {
            return this;
        } else {
            if (this.value > value && this.lNode != null) {
                return this.lNode.searchParent(value);
            } else if (this.value < value && this.rNode != null){
                return this.rNode.searchParent(value);
            }else {
                return null;
            }
        }
    }
}
