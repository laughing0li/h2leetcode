package heap;

import java.util.Arrays;

public class Heap {
    
    public static void main(String[] args) {
        // 数组模拟的是二叉树
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 
     * @param num 非叶子结点的数量
     */
    public static void heapSort(int[] arr) {
        // arr.length / 2 - 1可以找到二叉树中非叶子结点的个数
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    /**
     * 二叉树用数组进行表示
     * @param arr 待调整的二叉树
     * @param i 一共有几个非叶子结点
     * @param length 二叉树的长度
     */
    public static void adjustHeap(int arr[], int i, int length) {
        // 将最后一个非叶子节点存储到temp
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 首先比较k+1是否小于二叉树长度
            // 然后比较该节点的左右子节点的大小
            if (k + 1 < length && arr[k] < arr[k+1]){
            // 如果右子节点大，那么就将k指向右子节点
                k++;
            }
            // 如果右子节点大于父节点
            if (arr[k] > temp) {
                // 将右子节点放到父节点
                arr[i] = arr[k];
                // 将i 指向右子节点。
                i = k;
            } else {
                break;
            }
        }
        // 当循环结束，这时候的i是指向的右子节点。
        arr[i] = temp;
    }
}
