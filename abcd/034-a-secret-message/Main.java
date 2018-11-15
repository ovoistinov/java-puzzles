import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
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
            solveWithBitSet(in, out);
        }
    }

    // Runtime O(n2)
    // Memory  O(n)
    private void solveSimple(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();

        for (int i=0; i < s.length() - k + 1; i++) {
            if (s.lastIndexOf(s.substring(i, i+k)) != i) {
                out.print("YES");
                return;
            }
        }

        out.print("NO");
    }

    // Runtime O(n)
    // Memory  O(n*k)
    private void solveWithHashMap(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();

        Set<String> chunks = new HashSet<>();

        for (int i=0; i < s.length() - k + 1; i++) {
            String chunk = s.substring(i, i+k);

            if (chunks.contains(chunk)) {
                out.print("YES");
                return;
            } else {
                chunks.add(chunk);
            }
        }

        out.print("NO");
    }

    // Runtime O(n)
    // Memory  O(n)
    private void solveWithBitSet(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        char[] c = in.next().toCharArray();

        int mod = 1;
        for (int i=0; i < k; i++) {
            mod *= 10;
        }

        BitSet bs = new BitSet(n);
        int temp = 0;

        for (int i=0; i < k-1 ; i++) {
            temp = temp * 10 + (c[i] - '0');
        }

        for (int i=k-1; i < n; i++) {
            temp = temp * 10 + (c[i] - '0');
            temp %= mod;

            if (bs.get(temp)) {
                out.print("YES");
                return;
            } else {
                bs.set(temp);
            }
        }

        out.print("NO");
    }
}
