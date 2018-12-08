import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.BitSet;

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
        int dist = in.nextInt();

        BitSet nums = new BitSet(n);

        for (int i=0; i < n; i++) {
            nums.set(i, in.nextInt() == 1);
        }

        int replacePos = -1;

        for (int i=0; i < dist; i++) {
            int count0 = 0;
            int count1 = 0;
            int pos0 = -1;
            int pos1 = -1;

            for (int ii = i; ii < n; ii += dist) {
                if (!nums.get(ii)) count0++;
                if (nums.get(ii)) count1++;

                if (!nums.get(ii) && count0 == 1) pos0 = ii;
                if (nums.get(ii) && count1 == 1) pos1 = ii;
            }

            if (count0 == 0 || count1 == 0) {
                continue;
            } else if (count0 > 1 && count1 > 1) {
                out.print("FAIL");
                return;
            } else if (replacePos != -1) {
                out.print("FAIL");
                return;
            }  else if (count0 == 1 && count1 == 1) {
                replacePos = Math.min(pos0, pos1);
            } else if (count0 == 1) {
                replacePos = pos0;
            } else if (count1 == 1) {
                replacePos = pos1;
            }
        }

        out.printf("OK%n%d", ++replacePos);
    }
}
