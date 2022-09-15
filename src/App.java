import java.util.ArrayList;
import java.util.Stack;

import stack.ReverseCal;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<String> nStack = new Stack<>();
        Stack<String> oStack = new Stack<>();
        String str = "10+2*4+(5*4+4)/4";
        ReverseCal cal = new ReverseCal(5);
        Stack<String> stack = cal.experToRevExpersion(cal.stringToList(str));
        System.out.println(cal.getResult(stack));
    }
}
