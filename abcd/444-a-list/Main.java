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
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int[] n = readAndPrepareInput(in);

        int left = n[0];
        int right = n[0];

        StringBuilder result = new StringBuilder();
        StringBuilder withCommas = new StringBuilder();
        withCommas.append(left);

        for (int i=1; i < n.length; i++) {
            if (n[i-1] + 1 == n[i]) {
                withCommas.append(", ");
                withCommas.append(n[i]);

                right++;
            } else if (n[i-1] != n[i]) {
                String withDots = left + ", ..., " + right;

                // Don't add the separator to beginning of the result string
                if (result.length() > 0) {
                    result.append(", ");
                }

                if (withDots.length() > withCommas.length()) {
                    result.append(withCommas);
                } else {
                    result.append(withDots);
                }

                left = n[i];
                right = n[i];

                withCommas.setLength(0);
                withCommas.append(n[i]);
            }
        }

        out.print(result.toString());
    }

    private int[] readAndPrepareInput(Scanner in) {
        int[] init = new int[in.nextInt()];

        for (int i=0; i < init.length; i++) {
            init[i] = in.nextInt();
        }

        Arrays.sort(init);

        // To avoid post-loop processing, we add an artificial element
        // to the end of the array so that on the last iteration 
        // the program will run through the out-of-sequence case.
        int[] result = new int[init.length + 1];
        System.arraycopy(init, 0, result, 0, init.length);
        result[result.length - 1] = result[result.length - 2] + 2;

        return result;

    }
}