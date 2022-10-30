package leetcode;

/**
 * 合并两个有序链表，合并后的链表也是有序的
 * 可以使用递归和迭代的方式
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    // 利用迭代的方式进行合并
    // 原理：迭代的比较两个链表的当前位的大小，将小的添加到新的链表，并且 将小的对应的那个链表
    // 向next前进一步。当 list1 或者 list2 为空的时候，另一个链表也许还有数据
    // 所以将新链表的当前tmp的next 指向剩余的 即可完成拼接
    public static ListNode mergeTListNode(ListNode list1, ListNode list2) {
        // 将找到的较小的值放入添加到pre.next
        ListNode pre = new ListNode(0);
        ListNode tmp = pre;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        // list1 和 list2 可能还有数据，所以直接将tmp的next指向剩余的数据
        tmp.next = list1 == null ? list2 : list1;
        return pre.next;
    }

}
