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
            solveWithBits(in, out);
        }
    }

    private void solveWithBits(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int bitCount = 32 - Integer.numberOfLeadingZeros(n);

        int max = n;

        for (int i=0; i < bitCount - 1; i++) {
            n = rotateRight(n, bitCount);
            max = Math.max(max, n);
        }

        out.print(max);
    }

    private int rotateRight(int n, int bitCount) {
        return (n >> 1) ^ ((n&1) << (bitCount - 1));
    }

    private void solveWithStrings(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String ns = Integer.toString(n, 2);
        int max = n;
        int currentNumber = n;

        for (int i=0; i < ns.length(); i++) {
            ns = rotateRight(ns);
            max = Math.max(max, Integer.parseInt(ns, 2));
        }

        out.print(max);
    }

    private String rotateRight(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }
}