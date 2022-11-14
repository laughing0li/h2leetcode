package leetcode;

public class RotateRight {
    
    public static void main(String[] args) {

    }


    // 本题的解题思路：从最后开始反转，一共要反转k次。说明反转在len - k - 1的后一个位置结束。
    // 所以只需要找到当前链表的第len - k - 1位置 和 最后一个位置
    //首先将找到的最后一个位置先指向当前的head 然后 重新让head 等于 len - k这个位置 也就是下面的temp.next。 
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode node = head, temp = head;
        int n = 1;
        // 为啥n要从1 开始 因为while循环当node.next  == null 的时候就退出了
        // 但是这个时候的node也是一个节点 还没来得及加1 就退出了，所以需要从1 开始
        while (node.next != null) {
            n++;
            node = node.next;
        }                                                                                                                            
        // 如果k很大超过了list的长度，那么就需要取余。所以直接先取余
        k %= n;
        for (int i = 0; i < n - k - 1; i++) temp = temp.next;
        node.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}