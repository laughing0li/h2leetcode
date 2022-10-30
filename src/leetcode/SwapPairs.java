package leetcode;

/**
 * 给定一个链表头，将该链表的元素两两交换
 * 1 <-> 2  3<->4 交换等
 */
public class SwapPairs {

    // 递归方法
    public ListNode swapPairs(ListNode head) {
        // 满足该条件就终止
        if (head == null || head.next == null) return head;
        // eg： 链表是 1->2->3->4
        // 将 2 作为头结点。因为是互换，所以head.next 就 会变成头结点
        ListNode  tmp = head.next;
        // swapPairs(tmp.next) 会返回 4 -> 3 
        // 而将head.next 指向  返回的 4 -> 3 就是 1 -> 4 -> 3
        head.next = swapPairs(tmp.next);
        // 然后将头结点 2 的next 指向 head 节点 就变成 => 2 1 4 3
        tmp.next = head;
        return tmp;
    }
}
