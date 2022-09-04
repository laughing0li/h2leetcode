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
        SingleLinkedList sLinkedList = new SingleLinkedList();
        sLinkedList.addNode(node1);
        sLinkedList.addNode(node2);
        sLinkedList.addNode(node3);
        sLinkedList.addNode(node4);
        sLinkedList.addNodeById(node5);
        sLinkedList.addNodeById(node6);

        sLinkedList.display();

    }
}
