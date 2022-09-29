package hashtable;

public class EmpLinkedList {
    // 头指针，默认为空。 规定头结点就指向第一个元素
    Employee head;
    public void add(Employee emp) { 
        // 判断是否第一次加入，如果是就将head指向该元素。并返回
        if (head == null) {
            head = emp;
            return;
        }
        // 头结点添加过后不能动，需要辅助节点
        Employee temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    public void list() {
        if (head == null) {
            return;
        }
        Employee temp = head;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
    public void head() {
        System.out.println(head);
    }
    public Employee find(int empId) {
        if (head == null) {
            System.err.println("It's empty!");
            return null;
        }
        Employee temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.id == empId) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public boolean deleteById(int empId) {
        if (head == null) {
            System.err.println("It's empty!");
            return false;        
        }
        Employee temp = head;
        // 需要考虑要删除头结点的需要，先将头结点的信息暂存到temp
        // 然后将头结点指向其下一个节点
        if (head.id == empId) {
            head = temp.next;
            // 记得要return，否则还会进行下面的while循环
            return true;
        }        
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 当temp的下一个节点就是要删除的节点，这样才好操作进行删除
            if (temp.next.id == empId) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return true;
    }

}
