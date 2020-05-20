package tree;

/**
 * @program: DataStructure->TreeNode
 * @description:
 * @author: daqianliu
 * @create: 2019-09-12 13:55
 **/
public class BalancedTreeNode {
    int value;

    BalancedTreeNode lNode;
    BalancedTreeNode rNode;

    public BalancedTreeNode(int value) {
        this.value = value;
    }

    //设置左儿子
    public void setlNode(BalancedTreeNode lNode) {
        this.lNode = lNode;
    }

    //设置右儿子
    public void setrNode(BalancedTreeNode rNode) {
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

    public BalancedTreeNode frontSearch(int i) {
        BalancedTreeNode target = null;
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
        BalancedTreeNode parent = this;
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
     * 返回当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(lNode == null ? 0 : lNode.height(), rNode == null ? 0 : rNode.height()) + 1;
    }

    /**
     * 获取左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (lNode == null) {
            return 0;
        }
        return lNode.height();
    }

    /**
     * 获取右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (rNode == null) {
            return 0;
        }
        return rNode.height();
    }

    /**
     * 二叉排序树
     *
     * @param node
     */
    public void add(BalancedTreeNode node) {
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
        //检查是否平衡
        //进行右旋转
        if (leftHeight() - rightHeight() >= 2) {
            //双旋转
            if (lNode != null && lNode.leftHeight() < lNode.rightHeight()) {
                lNode.leftRotate();
                rightRotate();
            } else {
                //单旋转
                rightRotate();
            }

        } else if (rightHeight() - leftHeight() >= 2) {
            //双旋转
            if (rNode != null && rNode.rightHeight() < rNode.leftHeight()) {
                rNode.rightHeight();
                leftRotate();
            }
            leftRotate();
        }
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        //创建一个新节点，值等于当前节点的值
        BalancedTreeNode newRight = new BalancedTreeNode(value);
        //把新节点的右子树设置为当前节点的右子树
        newRight.rNode = rNode;
        //把新节点的左子树设置为当前节点的左子树的右子树
        newRight.lNode = lNode.rNode;
        //把当前节点的值换为左子节点的值
        value = lNode.value;
        //把当前节点的左子树设置为左子树的左子树
        lNode = lNode.lNode;
        //把当前节点的右子树设置为新节点
        rNode = newRight;
    }

    public void leftRotate() {
        BalancedTreeNode newLeft = new BalancedTreeNode(value);
        newLeft.lNode = lNode;
        newLeft.rNode = rNode.lNode;
        value = rNode.value;
        rNode = rNode.rNode;
        lNode = newLeft;
    }

    /**
     * 查找节点
     *
     * @param value
     */
    public BalancedTreeNode search(int value) {
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

    public BalancedTreeNode searchParent(int value) {
        if (this.lNode != null && this.lNode.value == value || this.rNode != null && this.rNode.value == value) {
            return this;
        } else {
            if (this.value > value && this.lNode != null) {
                return this.lNode.searchParent(value);
            } else if (this.value < value && this.rNode != null) {
                return this.rNode.searchParent(value);
            } else {
                return null;
            }
        }
    }
}
