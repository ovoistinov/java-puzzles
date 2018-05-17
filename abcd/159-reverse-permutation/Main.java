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
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int k = in.nextInt();
            p[k] = i;
        }

        for (int i = 1; i <= n; i++) {
            out.printf("%d ", p[i]);
        }
    }
}