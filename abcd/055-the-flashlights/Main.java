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
        int r = in.nextInt();
        double areaSingle = in.nextInt();

        double d = Math.sqrt(1.0*(x2-x1)*(x2-x1) + 1.0*(y2-y1)*(y2-y1));
        double area = 2*Math.PI*r*r;

        if (d == 0) {
            area -= Math.PI*r*r;
        } else if (d > 0 && d < r*2) {
            double triangleArea = d/4*Math.sqrt((4*r*r - d*d));
            double sectorArea = r*r*Math.acos(d/(2*r));
            double intersection = 2*(sectorArea - triangleArea);

            area -= intersection;
        }

        if (area > areaSingle) {
            out.print("YES");
        } else {
            out.print("NO");
        }
    }
}