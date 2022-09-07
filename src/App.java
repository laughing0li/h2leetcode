import linkedlist.HeroNode;
import linkedlist.SingleCirledLinkedList;
import stack.StackArray;

public class App {
    public static void main(String[] args) throws Exception {
        StackArray sArray = new StackArray(5);
        sArray.push(1);
        sArray.push(2);
        sArray.push(3);
        sArray.push(4);
        sArray.push(5);
        sArray.pop();
        sArray.list();
        System.out.println("==========");
        System.out.println(sArray.count());
    }
}
