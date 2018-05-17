import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
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
            solveWithSingularComplexity(in, out);
        }
    }

    private void solveWithSingularComplexity(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        long count = 1L * n * (n + 1) * (n + 2) / 2;

        out.print(count);
    }

    private void solveWithQuadraticComplexity(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        long count = 0;

        for (int left = 0; left <= n; left++) {
            for (int right = left; right <= n; right++) {
                count += left + right;
            }
        }

        out.print(count);
    }
}