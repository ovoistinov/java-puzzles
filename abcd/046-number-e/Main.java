import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.math.RoundingMode.HALF_UP;
import static java.lang.Character.getNumericValue;
import static java.lang.Character.forDigit;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveWithoutBigDecimal(in, out);
        }
    }

    private void solveWithoutBigDecimal(Scanner in, PrintWriter out) {
        int roundingScale = in.nextInt();
        StringBuilder e = new StringBuilder("2.71828182845904523536028750");

        if (roundingScale == 0) {
            out.print(3);
            return;
        }

        int lastDigitIndex = roundingScale + 1;
        int nextAfterLastDigitIndex = lastDigitIndex + 1;
        char lastDigit = e.charAt(lastDigitIndex);
        char afterLastDigit = e.charAt(nextAfterLastDigitIndex);

        if (afterLastDigit >= '5') {
            e.setCharAt(lastDigitIndex, ++lastDigit);
        }

        out.print(e.substring(0, nextAfterLastDigitIndex));
    }

    private void solveWithBigDecimal(Scanner in, PrintWriter out) {
        int roundingScale = in.nextInt();
        BigDecimal e = new BigDecimal("2.7182818284590452353602875");

        out.print(e.round(new MathContext(roundingScale + 1, HALF_UP)));
    }
}