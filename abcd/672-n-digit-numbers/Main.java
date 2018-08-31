import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveWithRecursion(in, out);
        }
    }

    private void solveWithRecursion(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        if (n == 1) {
            out.print("10 0");
        } else {
            Result result = new Result(0, null);
            StringBuilder prefix = new StringBuilder(n);
            countNumbers(prefix, n, 0, 1, result);

            out.printf("%d %s", result.count, result.min);
        }
    }

    private void countNumbers(StringBuilder prefix, int remDigits, int sum, int mul, Result result) {
        if (mul >= 90) {
            return;
        } else if (remDigits == 0) {
            if (sum == mul) {
                result.count++;

                if (result.min == null) {
                    result.min = prefix.toString();
                }
            }

            return;
        }

        for (int i=1; i <= 9; i++) {
            prefix.append(i);

            countNumbers(prefix, remDigits-1, sum+i, mul*i, result);

            prefix.setLength(prefix.length() - 1);
        }
    }

    private static class Result {
        int count;
        String min;

        public Result(int count, String min) {
            this.count = count;
            this.min = min;
        }
    }
}
