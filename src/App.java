import linkedlist.HeroNode;
import linkedlist.SingleLinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        HeroNode node1 = new HeroNode(1, "wo");
        HeroNode node2 = new HeroNode(2, "te");
        HeroNode node3 = new HeroNode(3, "hh");
        HeroNode node4 = new HeroNode(4, "tt");
        SingleLinkedList sLinkedList = new SingleLinkedList();
        sLinkedList.addNode(node1);
        sLinkedList.addNode(node2);
        sLinkedList.addNode(node3);
        sLinkedList.addNode(node4);

        sLinkedList.display();

        System.out.println(node1.next);
    }
}
