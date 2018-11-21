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

    // Runtime O(n)
    // Memory O(1)
    // Minimum runtime: single pass should be enough. The worst case is 
    // ~100_000 * 10^9 > Integer.MAX_VALUE, which means count is long.
    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int prev = in.nextInt();
        int max = prev;
        long count = 0;

        for (int i=1; i < n; i++) {
            int cur = in.nextInt();

            count += Math.max(0, cur - prev);
            max = Math.max(max, cur);

            prev = cur;
        }

        if (prev < max) count += max - prev;

        out.print(count);
    }
}
