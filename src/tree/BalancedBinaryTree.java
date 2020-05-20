package tree;

/**
 * @program: DataStructure->BinarySortTree
 * @description: 二叉排序树
 * @author: daqianliu
 * @create: 2019-09-14 13:48
 **/
public class BalancedBinaryTree {
    BalancedTreeNode root;

    /**
     * 向二叉排序树中添加节点
     *
     * @param node
     */
    public void add(BalancedTreeNode node) {
        //如果是一颗空树
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void frontShow() {
        if (root != null) {
            root.frontShow();
        }
    }

    public void middleShow() {
        if (root != null) {
            root.middleShow();
        }
    }

    public BalancedTreeNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //找到这个节点
            BalancedTreeNode target = search(value);
            if (target == null) {
                return;
            }
            //找到它的父节点
            BalancedTreeNode parent = searchParent(value);
            //要删除的节点是叶子节点
            if (target.lNode == null && target.rNode == null) {
                //要删除的节点是父节点的左子节点
                if (parent.lNode.value == value) {
                    parent.lNode = null;
                } else {
                    //要删除的节点是父节点的右子节点
                    parent.rNode = null;
                }
            } else if (target.lNode != null && target.rNode != null) {
                //要删除的节点有两个子节点的情况

                //删除右子树中值最小的节点，获取该节点的值
                int min = deleteMin(target.rNode);
                //替换目标节点中的值
                target.value = min;
            } else {
                //右左子节点
                if (target.lNode != null) {
                    //要删除的节点有一个左子节点或右子节点
                    if (parent.lNode.value == value) {
                        parent.lNode = target.lNode;
                    } else {
                        parent.rNode = target.lNode;
                    }
                } else {
                    if (parent.lNode.value == value) {
                        parent.lNode = target.rNode;
                    } else {
                        parent.rNode = target.rNode;
                    }
                }
            }

        }
    }

    /**
     * 删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(BalancedTreeNode node) {
        BalancedTreeNode target = node;
        //循环递归向左找
        while (node.lNode!=null){
            target = target.lNode;
        }
        //删除最小的这个节点
        delete(target.value);
        return target.value;
    }

    /**
     * 搜索父节点
     *
     * @param value
     * @return
     */
    public BalancedTreeNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
}
