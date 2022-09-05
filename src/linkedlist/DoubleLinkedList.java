package linkedlist;

public class DoubleLinkedList {
    HeroNode head = new HeroNode(0, "");

    public boolean isEmpty() {
        return head.next == null;
    }

    public void addNode(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addNodeByIdOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.id < node.id && node.id < temp.next.id) {
                // find the right place
                flag = true;
                break;
            }
            if (temp.id == node.id) {
                throw new RuntimeException("This Id Already exists");
            }
            temp = temp.next;
        }
        if (flag) {
            node.next =temp.next;
            temp.next = node;
            node.pre = temp;
        }
    }

    public HeroNode getNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.pre.next = null;
        return temp;
    }

    public void delNodeById(int id) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // 当temp就是最后一个的时候，temp.next 就是空 所以需要判断
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("didn't find the one to be delete!");
        }
    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
