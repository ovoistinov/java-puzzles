import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        int xa = in.nextInt();
        int ya = in.nextInt();

        int x;
        int y;

        if (y1 == y2) {
            int dy = (ya - y1)*2;
            x = xa;
            y = ya - dy;
        } else if (x1 == x2) {
            int dx = (xa - x1)*2;
            x = xa - dx;
            y = ya;
        } else {
            throw new AssertionError("Invalid input data. The segments must be parallel to one of the axis.");
        }

        out.printf("%d %d", x, y);
    }
}