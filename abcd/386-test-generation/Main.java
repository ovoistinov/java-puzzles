import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

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

        Point[] result = new Point[n];

        Random rand = new Random(42L);

        int i = 0;
        while (true) {
            int x = rand.nextInt(20_001) - 10_000;
            int y = rand.nextInt(20_001) - 10_000;
            Point p = new Point(x, y);

            if (validPoint(p, result, i)) {
                result[i] = p;
                i++;

                if (i == n) break;
            }
        }

        out.println("YES");

        for (Point p : result) out.printf("%d %d%n", p.x, p.y);
    }

    private boolean validPoint(Point p, Point[] result, int last) {
        if (last < 2) return true;

        for (int i=0; i < last; i++) {
            for (int j=i+1; j < last; j++) {
                Point p1 = result[i];
                Point p2 = result[j];

                if ((p.x-p1.x)*(p2.y-p1.y) == (p2.x-p1.x)*(p.y-p1.y)) return false;
            }
        }

        return true;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
