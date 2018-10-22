import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

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

        int[] seq = new int[n];
        for (int i=0; i < n; i++) {
            seq[i] = in.nextInt();
        }

        int[] seqSorted = seq.clone();
        Arrays.sort(seqSorted);

        int maxCountNumber = seqSorted[0];
        int count = 1;
        int maxCount = 1;

        for (int i=1; i < n; i++) {
            if (seqSorted[i] == seqSorted[i-1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                maxCountNumber = seqSorted[i-1];
            }
        }

        for (int i=0; i < n; i++) {
            if (seq[i] != maxCountNumber) {
                out.printf("%d ", seq[i]);
            }
        }

        for (int i=0; i < maxCount; i++) {
            out.printf("%d ", maxCountNumber);
        }
    }
}