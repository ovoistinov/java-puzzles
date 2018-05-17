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
        int size = ((int) (n * Math.log10(2))) + 1;
        int[] digit = new int[size];

        digit[0] = 2;

        for (int i=0; i < n-1; i++) {
            multiplyBy2(digit);
        }

        for (int i=digit.length-1; i >= 0; i--) {
            out.print(digit[i]);
        }
    }

    private void multiplyBy2(int[] digit) {
        int remainder = 0;

        for (int i=0; i < digit.length; i++) {
            int calc = 2*digit[i] + remainder;

            digit[i] = calc % 10;
            remainder = calc / 10;
        }

        if (remainder > 0) {
            throw new IllegalStateException("Result overflow");
        }
    }
}