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
        int r1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int r2 = in.nextInt();

        int dx = x2 - x1;
        int dy = y2 - y1;

        int d2 = dx * dx + dy * dy;

        out.print(circlesIntersect(d2, r1, r2));
    }

    private String circlesIntersect(int d2, int r1, int r2) {
        return (r1 - r2) * (r1 - r2) <= d2 && d2 <= (r1 + r2) * (r1 + r2)
                ? "YES" 
                : "NO";
    }
}