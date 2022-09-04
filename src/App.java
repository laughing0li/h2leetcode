import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue aq = new ArrayQueue(4);
        CircledArrayQueue caq = new CircledArrayQueue(4);
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
                    caq.display();
                    break;
                case "e":
                    s.close();
                    loop = false;
                    break;
                case "g":
                    System.out.println(caq.get());
                    break;
                case "t":
                    System.out.println(caq.total());
                case "a":
                    System.out.println("输入一个数字");
                    int num = s.nextInt();
                    caq.add(num);
                    break;
            }
        }
    }
}
