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
        int n = in.nextInt();

        int bestDivisor = 1;
        int bestDivisorDigitSum = 1;

        for (int divisor = 2; divisor <= n; divisor++) {
            if (n % divisor == 0) {
                int divisorDigitSum = getDigitSum(divisor);

                if (divisorDigitSum > bestDivisorDigitSum) {
                    bestDivisor = divisor;
                    bestDivisorDigitSum = divisorDigitSum;
                }
            }
        }

        out.print(bestDivisor);
    }

    private int getDigitSum(int n) {
        int digitSum = 0;

        while (n > 0) {
            digitSum += n % 10;
            n /= 10;
        }

        return digitSum;
    }
}