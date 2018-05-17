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
            solveWithPrefixFunction(in, out);
        }
    }

    private void solveWithPrefixFunction(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] num = new int[n];

        for (int i=0; i < n; i++) {
            num[i] = in.nextInt();
        }

        int[] prefix = prefixFunction(num); // contract: prefix[last] -> len
        int p = prefix[n-1];

        while(true) {
            int period = n - p;

            if ((n-1) % period == 0) {
                out.print(period);
                return;
            } else {
                p = prefix[p-1];
            }
        }
    }

    private int[] prefixFunction(int[] s) {
        int[] p = new int[s.length];
        int k = 0;
        for (int i = 1; i < s.length; i++) {
            while (k > 0 && s[k] != s[i]) {
                k = p[k - 1];
            }

            if (s[k] == s[i]) {
                ++k;
            }

            p[i] = k;
        }

        return p;
    }

    private void solveSimple(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] s = new int[n];

        for (int i=0; i < n; i++) {
            s[i] = in.nextInt();
        }

        for (int d = 1; d <= n - 1; d++) {
            if ((n - 1) % d == 0) {
                boolean allNumbersEqual = true;

                for (int j=d; j < n; j++) {
                    if (s[j - d] != s[j]) {
                        allNumbersEqual = false;
                        break;
                    }
                }

                if (allNumbersEqual) {
                    out.print(d);
                    return;
                }
            }
        }
    }
}