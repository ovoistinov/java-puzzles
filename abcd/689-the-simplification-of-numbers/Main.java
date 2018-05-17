import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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

        for (int i=0; i < n; i++) {
            ScaledNumber conv = getSimplestRepresentation(in.nextInt());

            out.printf("%d %s%n", conv.scale, conv.representation);
        }
    }

    private ScaledNumber getSimplestRepresentation(int n) {
        ScaledNumber simplest = null;

        for (int scale = 2; scale <= 36; scale++) {
            ScaledNumber temp = new ScaledNumber(n, scale);

            if (simplest == null || simplest.complexity > temp.complexity) {
                simplest = temp;
            }
        }

        return simplest;
    }

    private class ScaledNumber {
        String representation;
        int complexity;
        int scale;

        public ScaledNumber(int initialNumber, int scale) {
            this.representation = Integer.toString(initialNumber, scale).toUpperCase();
            this.scale = scale;
            this.complexity = representation.length() + countDistinctChars(representation);
        }

        private int countDistinctChars(String s) {
            Set<Character> chars = new HashSet<Character>();

            for (int i = 0; i < s.length(); i++) {
                chars.add(s.charAt(i));
            }

            return chars.size();
        }

        private char convertToRadix(int n, int scale) {
            if (n >= 0 && n <= 9) {
                return (char) ('0' + n);
            } else if (n > 9 && n <= 36) {
                return (char) ('A' + n - 10);
            } else {
                throw new AssertionError("Invalid input number to convert.");
            }
        }
    }
}