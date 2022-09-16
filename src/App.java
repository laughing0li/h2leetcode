import recursion.EightQueens;
import recursion.Maze;

public class App {
    public static void main(String[] args) throws Exception {
        EightQueens eQueens = new EightQueens(8);
        eQueens.check(0);
        System.out.println(EightQueens.count);
    }

}
