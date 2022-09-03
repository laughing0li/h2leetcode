import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue aq = new ArrayQueue(4);
        Scanner s = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while (loop) {
            System.out.println("d(display): ");
            System.out.println("e(exit): ");
            System.out.println("g(get): ");
            System.out.println("a(add): ");
            key = s.next();
            switch (key) {
                case "d":
                    aq.display();
                    break;
                case "e":
                    s.close();
                    loop = false;
                    break;
                case "g":
                    System.out.println(aq.get());
                    break;
                case "a":
                    System.out.println("输入一个数字");
                    int num = s.nextInt();
                    aq.add(num);
                    break;
            }
        }
    }
}
