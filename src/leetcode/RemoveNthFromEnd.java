package leetcode;

/**
 * 删除单链表的倒数第k个元素
 */
public class RemoveNthFromEnd {
    public static void main(String[] args){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        removeNthFromEnd(node1, 5);
    }

    // 最主要的原理是设置两个指针start end。先让start向next的方向移动n次
    // 这个时候start和end的间隔就是n。然后让start和end一起向next移动。直到start.next == null
    // 这个时候的end就是待删除节点的前一个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        // 构造一个temp，将它的next指向head。因为head也可能被删除，有利于操作
        ListNode temp = new ListNode(0);        
        temp.next = head;
        ListNode start = temp, end = temp;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return temp.next;
    }
}
