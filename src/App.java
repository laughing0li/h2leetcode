import linkedlist.DoubleLinkedList;
import linkedlist.HeroNode;
import linkedlist.SingleLinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        HeroNode node1 = new HeroNode(1, "wo");
        HeroNode node2 = new HeroNode(2, "te");
        HeroNode node3 = new HeroNode(5, "hh");
        HeroNode node4 = new HeroNode(8, "tt");
        HeroNode node5 = new HeroNode(4, "sdsd");
        HeroNode node6 = new HeroNode(7, "sdsd");
        HeroNode node8 = new HeroNode(3, "123123");
        DoubleLinkedList dList = new DoubleLinkedList();
        dList.addNode(node1);
        dList.addNode(node2);
        dList.addNode(node3);
        dList.addNode(node4);
        dList.addNode(node5);
        dList.addNode(node6);
        dList.addNodeByIdOrder(node8);
        dList.display();
    }
}
