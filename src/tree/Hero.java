package tree;

public class Hero {
    private int no;
    private String name;
    private Hero left;
    private Hero right;

    // 初始化Hero，默认左右为null
    public Hero(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getLeft() {
        return this.left;
    }

    public void setLeft(Hero left) {
        this.left = left;
    }

    public Hero getRight() {
        return this.right;
    }

    public void setRight(Hero right) {
        this.right = right;
    }

    // 前序遍历
    public void preOrder(Hero root) {
        // 前序遍历需要先打印root节点
        System.out.println(root);
        if (root.left != null) {
            root.left.preOrder(root.left);
        }
        if (root.right != null) {
            root.right.preOrder(root.right);
        }
    }
    // 前序查找
    public Hero preFind(Hero root, int id) {
        if (root.getNo() == id) {
            return root;
        }
        // 声明一个temp用于接收root.left.preFind(root, id)返回的值
        // root.left.preFind(root, id)的返回值就是
        // if (root.getNo() == id) {
            // return root; 这个判断return的值
        // }
        // root.right.preFind同理
        Hero temp = null;
        if (root.left != null) {
            temp = root.left.preFind(root.left, id);
        }
        // 当左边的子节点遍历完毕之后，需要判断是否找到了。如果已经找到，但是没有返回
        // 那么右边的遍历会将找到的结果覆盖掉。应该就是会返回一个null
        if (temp != null) {
            return temp;
        } 
        if (root.right != null) {
            temp = root.right.preFind(root.right, id);
        }
        return temp;
    }

    // 中序遍历
    public void infixOrder(Hero root) {
        if (root.left != null) {
            root.left.infixOrder(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            root.right.infixOrder(root.right);
        }
    }
    // 中序查找
    public Hero infixFind(Hero root, int id) {
        // 声明一个Hero节点用于接收查找到的元素
        Hero temp = null;
        // 中序查找，先判断当前节点是否有左节点，如果有就递归进行查找
        if (root.left != null) {
            // 将查询到的结果返回给temp
            temp = root.left.infixFind(root.left, id);
        }
        // 先判断是否在左边递归的时候找到了，找到了就return。
        if (temp != null) {
            return temp;
        }
        // 判断查询的是否是root节点
        if (root.getNo() == id) {
            return root;
        }
        // 如果上面的都没查找到，再从右边进行递归查询
        if (root.right != null) {
            temp = root.right.infixFind(root.right, id);
        }
        return temp;
    }

    // 后序遍历
    public void postOrder(Hero root) {
        if (root.left != null) {
            root.left.postOrder(root.left);
        }
        if (root.right != null) {
            root.right.postOrder(root.right);
        }
        System.out.println(root);
    }
    // 后序查找
    public Hero postFind(Hero root, int id) {
        Hero temp = null;
        if (root.left != null) {
            temp = root.left.postFind(root.left, id);
        }
        if (temp != null) {
            return temp;
        }
        if (root.right != null) {
            temp = root.right.postFind(root.right, id);
        }
        if (root.getNo() == id) {
            return root;
        }
        return temp;
    }

    /**
     * 1. 首先约定这个删除功能
     * 2. 删除某个节点，不管它是否还有左右子节点 我们都将其一起删除
     * @param root 根节点
     * @param id 需要删除的某个节点的id
     */
    public void delById(Hero root, int id) {
        // 首先检查根节点的左右节点是否是想找的
        if (root.left != null && root.left.getNo() == id) {
            root.left = null;
            return;
        }
        // 首先需要判断当前节点的左右节点是否为空
        if (root.right != null && root.right.getNo() == id) {
            root.right = null;
            return;
        }
        if (root.left != null) {
            root.left.delById(root.left, id);
        }
        if (root.right != null) {
            root.right.delById(root.right, id);
        }
    }

    @Override
    public String toString() {
        return "{" +
            " no='" + getNo() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

    /**
     * 该删除方法规定，如果被删除的节点含有子节点
     * 1. 如果只有其中一个子节点，那么就用该子节点代替它
     * 2. 如果左右子节点都有：
     * 2.1 先看左右子节点是否都是
     * 
     * @param root
     * @param id
     */
    public void del(Hero root, int id) {

    }

}
