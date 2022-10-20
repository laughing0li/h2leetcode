package leetcode;


public class AddTwoNums {

    public ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        // 用于存储进位值
        int carry = 0;
        // 因为是两个链表相加，所以只要其中一个不为空那么就需要进行相加处理。
        while (l1 != null || l2 != null) {
            // 下面是用于当两个链表长度不同的时候，给短的那个用0进行补位
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            // 第一次相加操作, eg: (7 + 9) % 10 = 6，所以补位为1 当前位为6
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            // eg: (7 + 9) / 10 = 1 补位为1
            carry = sum / 10;
            // 遍历链表，直到最后
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        // 将头结点返回，这个链表就是最终答案
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; } 
}