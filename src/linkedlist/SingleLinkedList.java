package linkedlist;
/**
 * 单链表的实现
 */
public class SingleLinkedList {
    HeroNode head = new HeroNode(0, "");


    public boolean isEmpty() {
        return head.next == null;
    }

    public void addNode(HeroNode node) {
        // 头结点不能动，需要一个辅助节点
        HeroNode temp = head;
        while (true) {
            // 遍历到链表尾部
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public HeroNode getNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        HeroNode temp = head;
        while(true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        HeroNode temp = head;
        while(true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
