import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Math;

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
            solveWithCustomClass(in, out);
        }
    }

    private void solveWithCustomClass(Scanner in, PrintWriter out) {
        String a = in.next();
        String b = in.next();

        PositiveBigInteger pbia = new PositiveBigInteger(a);
        PositiveBigInteger pbib = new PositiveBigInteger(b);

        out.print(pbia.add(pbib));
    }

    private void solve(Scanner in, PrintWriter out) {
        String a = in.next();
        String b = in.next();

        String n1 = a.length() >= b.length() ? a : b;
        String n2 = a.length() >= b.length() ? b : a;

        int res = 0;
        int remainder = 0;
        int i1 = n1.length() - 1;
        int i2 = n2.length() - 1;
        StringBuilder sum = new StringBuilder();

        while (i1 >= 0) {
            if (i2 >= 0) {
                res = (n1.charAt(i1) - '0') + (n2.charAt(i2) - '0') + remainder;
                i2--;
            } else {
                res = (n1.charAt(i1) - '0') + remainder;
            }

            sum.append(res % 10);
            remainder = res / 10;

            i1--;
        }

        if (remainder > 0) {
            sum.append(remainder);
        }

        out.print(sum.reverse());
    }

    public class PositiveBigInteger {
        final int[] digits;

        public PositiveBigInteger(String val) {
            digits = new int[val.length()];

            for (int i=val.length() - 1; i >= 0; i--) {
                digits[val.length() - 1 - i] = val.charAt(i) - '0';
            }
        }

        int[] getMagnitude() {
            return digits;
        }

        private PositiveBigInteger(int[] digits) {
            this.digits = digits;
        }

        public PositiveBigInteger add(PositiveBigInteger val) {
            return new PositiveBigInteger(add(digits, val.getMagnitude()));
        }

        public int[] add(int[] a, int[] b) {
            if (a.length < b.length) {
                int[] temp = a;
                a = b;
                b = temp;
            }

            int remainder = 0;
            int sum = 0;
            int[] result = new int[a.length];

            for (int i=0; i < a.length; i++) {
                sum = a[i] + remainder;

                if (i < b.length) sum += b[i];

                result[i] = sum % 10;
                remainder = sum / 10;
            }

            if (remainder > 0) {
                int[] bigger = new int[result.length + 1];
                System.arraycopy(result, 0, bigger, 0, result.length);
                bigger[bigger.length - 1] = 1;
                result = bigger;
            }

            return result;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();

            for (int i=digits.length - 1; i >= 0; i--) {
                result.append((char) ('0' + digits[i]));
            }

            return result.toString();
        }
    }
}