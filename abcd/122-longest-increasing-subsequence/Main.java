import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveLogarithmic(in, out);
        }
    }

    // Runtime: O(n*log(n))
    // Memory: O(n)
    // Min runtime: O(n*log(n))
    private void solveLogarithmic(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] num = new int[n];

        for (int i=0; i < num.length; i++) {
            num[i] = in.nextInt();
        }

        int[] len = new int[num.length];
        int maxLen = 0;

        for (int i=0; i < num.length; i++) {
            int ins = Arrays.binarySearch(len, 0, maxLen, num[i]);

            if (ins < 0) {
                ins = -(ins + 1);
            }

            len[ins] = num[i];

            if (ins == maxLen) {
                maxLen++;
            }
        }

        out.print(maxLen);
    }

    // Runtime: O(n^2)
    // Memory: O(n)
    // Min runtime: O(n*log(n))
    private void solveQuadratic(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] num = new int[n];

        for (int i=0; i < num.length; i++) {
            num[i] = in.nextInt();
        }

        int[] len = new int[num.length];
        len[0] = 1;

        int maxLen = 1;

        for (int i=0; i < num.length; i++) {
            len[i] = 1;

            for (int j=0; j < i; j++) {
                if (num[j] < num[i]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, len[i]);
        }

        out.print(maxLen);
    }
}
