import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.abs;

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
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        if (x1 == x2 && y1 == y2) {
            // same cell
            out.print(0);
            return;
        } else if ((x1 + y1) % 2 != (x2 + y2) % 2) {
            // one cell white one black
            out.print(0);
            return;
        } if (abs(x2 - x1) == abs(y2 - y1)) {
            // one the same diagonal
            out.print(1);
            return;
        } else {
            // find intersection of diagonals
            for (int i=1; i <= 8; i++) {
                for (int j=1; j <= 8; j++) {
                    if (abs(x1 - i) == abs(y1 - j) && 
                        abs(x2 - i) == abs(y2 - j)) {
                        out.println(2);
                        out.printf("%d %d", i, j);
                        return;
                    }
                }
            }
        }
    }
}