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
        int gx = in.nextInt();
        int gy = in.nextInt();
        int dx = in.nextInt();
        int dy = in.nextInt();
        int n = in.nextInt();

        for (int i=1; i <= n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (gopherCanBeSaved(gx, gy, dx, dy, x, y)) {
                out.print(i);
                return;
            }
        }

        out.print("NO");
    }

    private boolean gopherCanBeSaved(int gx, int gy, int dx, int dy, int x, int y) {
        long sqrGopherHoleDistance = sqrDistance(gx, gy, x, y) * 4;
        long sqrDogHoleDistance = sqrDistance(dx, dy, x, y);

        return sqrGopherHoleDistance <= sqrDogHoleDistance;
    }

    private long sqrDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
    }
}