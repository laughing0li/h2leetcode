public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue aq = new ArrayQueue(4);
        aq.add(1);
        aq.add(2);
        aq.add(3);
        aq.add(4);

        aq.display();
    }
}
