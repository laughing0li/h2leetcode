package linkedlist;

public class SingleCirledLinkedList {
    HeroNode head = new HeroNode(0, "head");

    // 添加节点到尾部
    public void addNode(HeroNode node) {
        HeroNode temp = head;
        // 首先判断是否是第一次添加节点，如果第一次添加那么先将head的next指向自己
        // 形成环状
        if (head.next == null) {
            head.next = head;
        }        
        while (true) {
            if (temp.next == head) {
                break;
            }
            temp = temp.next; 
        }
        temp.next = node;
        node.next = head;
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public void delNodeById(int id) {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty!");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == head) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("didn't find one with this id!");
        }

    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty!");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
        
    }

    public int count() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty!");
        }
        HeroNode temp = head;
        int count = 0;
        while (true) {
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    /**
     * 
     * @param startNo 从第几个节点开始
     * @param countNum 向后数countNum次
     */

    public void count(int startNo, int countNum) {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty!");
        }
        if (countNum < 1) {
            System.err.println("step can't less than 1!");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == head) {
                break;
            }
            // 找到需要开始的节点的前一个节点
            if (temp.next.id == startNo) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            while (true) {
                if (temp == head && count() == 1) {
                    break;
                }
                for (int i = 0; i < countNum - 1; i ++) {
                    temp = temp.next;
                }
                System.out.println(temp.next);    
                temp.next = temp.next.next;
            }
            
        }
    }


}
