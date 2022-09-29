package hashtable;

public class Employee {
    public int id;
    public String name;
    public Employee next; // next 默认为空，所以不需要初始化

    // 构造器初始化
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "id is " + this.id + " name is " + this.name;
    }
}
