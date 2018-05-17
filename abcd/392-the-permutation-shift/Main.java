import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collection;

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

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        int minIndex = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 1) {
                minIndex = i;
                break;
            }
        }

        for (int i = minIndex; i < p.length; i++) {
            out.printf("%d ", p[i]);
        }

        for (int i = 0; i < minIndex; i++) {
            out.printf("%d ", p[i]);
        }
    }
}