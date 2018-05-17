import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveAtoD(in, out);
        }
    }

    private void solveDtoA(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int count = 0;

        for (int d = (n + 3) / 4; d <= n - 3; d++) {
            for (int c = (n - d + 2) / 3; c <= min(d, n - d - 2); c++) {
                int from = (n - d - c + 1) / 2;
                int to = min(c, n - c - d - 1);

                count += to - from + 1;
            }
        }

        out.print(count);
    }

    private void solveAtoD(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int count = 0;

        for (int a = 1; a <= n/4; a++) {
            for (int b = a; b <= (n - a)/3; b++) {
                int from = b;
                int to = (n - a - b)/2;
                
                count += to - from + 1;
            }
        }

        out.print(count);
    }
}