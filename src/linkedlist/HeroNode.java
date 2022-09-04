package linkedlist;
public class HeroNode {
    public int id;
    public String name;
    public HeroNode next;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "my id is " + id + " my name is: " + name;
    }
}