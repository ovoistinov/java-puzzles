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
        int n = in.nextInt();

        int nSheets = (n+3)/4;
        int nPages = nSheets*4;

        int p1 = nPages;
        int p2 = 1;

        for (int i=1; i <= nSheets; i++ ) {
            out.printf("%d %d %d %d%n", i, 1, display(p1, n), p2);
            out.printf("%d %d %d %d%n", i, 2, display(p2 + 1, n), display(p1 - 1, n));

            p1 -= 2;
            p2 += 2;
        }
    }

    private int display(int value, int lim) {
        return value > lim ? 0 : value;
    }
}