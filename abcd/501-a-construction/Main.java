import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.max;
import static java.lang.Math.min;

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

        Rectangle[] r = new Rectangle[n];

        for (int i=0; i < r.length; i++) {
            r[i] = new Rectangle(in);
        }

        Rectangle b = new Rectangle(in);

        int area = 0;

        for (Rectangle a : r) {
            int ix1 = max(a.minX, b.minX);
            int ix2 = min(a.maxX, b.maxX);
            int iy1 = max(a.minY, b.minY);
            int iy2 = min(a.maxY, b.maxY);

            if (ix2 - ix1 > 0 && iy2 - iy1 > 0) {
                area += (ix2 - ix1) * (iy2 - iy1);
            }
        }

        out.print(area);
    }

    private class Rectangle {
        private final int minX;
        private final int minY;
        private final int maxX;
        private final int maxY;

        public Rectangle(Scanner in) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            this.minX = min(x1, x2);
            this.minY = min(y1, y2);
            this.maxX = max(x1, x2);
            this.maxY = max(y1, y2);
        }
    }
}