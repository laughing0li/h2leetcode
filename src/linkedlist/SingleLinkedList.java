package linkedlist;
/**
 * 单链表的实现
 */
public class SingleLinkedList {
    HeroNode head = new HeroNode(0, "");


    public boolean isEmpty() {
        return head.next == null;
    }

    // 按照id顺序添加node到指定位置
    // 第一种情况，node需要添加到链表中间
    // 第二种情况，node添加到链表尾部
    public void addNodeById(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.id < node.id && node.id <temp.next.id) {
                break;
            }
            if (temp.id == node.id) {
                throw new RuntimeException("This node is already exists");
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }


    // 添加node到尾部
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
