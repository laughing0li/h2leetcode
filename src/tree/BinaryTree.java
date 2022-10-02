package tree;

/**
 * 二叉树
 * 有三种遍历方式：
 * 1. 前序遍历：先输出父节点，再遍历左边子树和右边子树
 * 2. 中序遍历：先遍历左边子树，再输出父节点，然后遍历右边子树
 * 3. 后序遍历：先遍历左边子树，再遍历右边子树，最后输出父节点
 * 
 */
public class BinaryTree {
    // private Hero root;
    // public void setRoot(Hero root) {
    //     this.root = root;
    // }

    public void preOrder(Hero root) {
        if (root != null) {
            root.preOrder(root);
        } else {
            System.out.println("二叉树为空！");
        }
    }
    
    public Hero preFind(Hero root, int id) {
        if (root != null) {
            return root.preFind(root, id);
        } else {
            return null;
        }
    }

    public void infixOrder(Hero root) {
        if (root != null) {
            root.infixOrder(root);
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public Hero infixFind(Hero root, int id) {
        if (root != null) {
            return root.preFind(root, id);
        } else {
            return null;
        }
    }

    public void postOrder(Hero root) {
        if (root != null) {
            root.postOrder(root);
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public Hero postFind(Hero root, int id) {
        if (root != null) {
            return root.postFind(root, id);
        } else {
            return null;
        }
    }
}
