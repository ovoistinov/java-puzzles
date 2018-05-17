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
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        int p1p2 = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
        int p1p3 = (x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3);
        int p2p3 = (x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3);

        int x4;
        int y4;

        // Coordinates of the middle of the hypotenuse: xm = (x1 + x3) / 2; ym = (y1 + y3) / 2;
        // xm = (x2 + x4) / 2; x4 = 2*xm - x2; x4 = 2*((x1 + x3)/2) - x2 = x1 + x3 - x2;
        if (p1p2 + p2p3 == p1p3) {
            // p2 -- p3
            // |  /
            // p1
            x4 = x1 + x3 - x2;
            y4 = y1 + y3 - y2;
        } else if (p1p3 + p1p2 == p2p3) {
            // p1 -- p2
            // |  /
            // p3
            x4 = x2 + x3 - x1;
            y4 = y2 + y3 - y1;
        } else if (p2p3 + p1p3 == p1p2) {
            // p3 -- p1
            // |  /
            // p2
            x4 = x1 + x2 - x3;
            y4 = y1 + y2 - y3;
        } else {
            throw new AssertionError();
        }

        out.printf("%d %d", x4, y4);
    }
}