package hashtable;


public class HashTab {
    // empLinkedLists数组 用于存放链表
    public EmpLinkedList[] empLinkedLists;
    public int size;

    public HashTab(int size) {
        // 初始化该数组的大小
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];
        // 初始化的时候，需要给empLinkedLists数组中添加每一个链表。
        // 否则会报出空指针异常
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();;
        }
    }
    
    public void add(Employee employee) {
        int listId = hashFun(employee.id);
        // 将该id的员工存放到对应的链表
        // 加入listId 等于2，相当于将当前的employee加入到empLinkedLists数组的下标为2的那一个中
        // 数组的每一个元素就是一条链表
        empLinkedLists[listId].add(employee);
    }

    public void list() {
        // 记住数组的每一个元素就是一条链表
        for (int i = 0; i < size; i++) {
            if (empLinkedLists[i] != null) {
                empLinkedLists[i].list();
            }
        }
    }

    public Employee find(int empId) {
        int listId = hashFun(empId);
        return empLinkedLists[listId].find(empId);
    }

    public boolean deleteById(int empId) {
        int listId = hashFun(empId);
        empLinkedLists[listId].list();
        return empLinkedLists[listId].deleteById(empId);
    }

    // 散列函数，根据员工的id确定其应该存放的链表
    public int hashFun(int empId) {
        return empId % size; 
    }

}
