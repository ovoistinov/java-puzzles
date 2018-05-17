import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        if (!in.hasNext()) {
            out.print(0);
            return;
        }

        String seq = in.next();
        String leftArrow = "<--<<";
        String rightArrow = ">>-->";

        int count = count(seq, rightArrow) + count(seq, leftArrow);

        out.print(count);
    }

    private int count(String seq, String arrow) {
        int cursor = 0;
        int count = 0;

        while (cursor < seq.length()) {
            cursor = seq.indexOf(arrow, cursor);

            if (cursor == -1) {
                break;
            } else {
                count++;
                cursor++;
            }
        }

        return count;
    }

}