package tree;

/**
 *     1
 *    4 3
 *  2 5 3 7
 * int[] arr = {1 ,4 ,3, 2, 5, 3, 7};
 * 这个数组存储的信息是二叉树的节点。顺序如上所示
 * 从第一层开始从左往右开始
 * 现在的需求是：在我们遍历该数组的时候，打印出来可以是前序中序或者后序的方式
 * 
 * 寻找规律如下
 * 1. 顺序二叉树通常只考虑完全二叉树
 *    第n个元素的左右子节点包括父节点在数组中的位置 如下：所有计算 出来的数字都表示在数组中的下标
 *    例如上述数组：头结点为1，1的左子节点为 2*0+1 就是 4，右子节点为 2*0+2 就是3
 * 2. 第n个元素的左子节点 为 2 * n + 1
 * 3. 第n个元素的右子节点 为 2 * n + 2
 * 4. 第n个元素的父节点 为 (n - 1) / 2
 * 5. n 表示下标：说明也是从0开始的
 */
public class OrderBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1 ,4 ,3, 2, 5, 3, 7};
        OrderBinaryTree oTree = new OrderBinaryTree(arr);
        oTree.preOrder(0);

    }
    private int[] arr;

    public OrderBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 
     * @param index 表示数组的下标，一般为0️
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！");
        }
        // 因为是前序遍历，所以先打印出第一个
        System.out.println(arr[index]);
        // 首先要确定左右两边不能越界
        if ((index * 2 + 1) < arr.length) {
            // 这里找到当前index的左子节点
            preOrder(index * 2 + 1);
        }
        // 这里找到当前index的右子节点
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}
