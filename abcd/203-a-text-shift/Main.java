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
            solveSimple(in, out);
        }
    }

    private void solveSimple(Scanner in, PrintWriter out) {
        String s = in.next();
        String shifted = in.next();

        shifted += shifted;

        out.print(shifted.indexOf(s));
    }

    private void solve(Scanner in, PrintWriter out) {
        char[] s = in.next().toCharArray();
        char[] shifted = in.next().toCharArray();

        for (int i=0; i < s.length; i++) {
            if (equalsToShifted(s, shifted, i)) {
                out.print(i);
                return;
            }
        }

        out.print(-1);
    }

    private boolean equalsToShifted(char[] s, char[] shifted, int offset) {
        boolean equal = true;

        for (int i=0; i < s.length; i++) {
            if (s[i] != shifted[offset]) {
                return false;
            }

            offset++;

            if (offset > s.length - 1) {
                offset = 0;
            }
        }

        return equal;
    }
}