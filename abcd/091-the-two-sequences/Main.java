import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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

        int[] a = new int[n + 5];
        int[] b = new int[n + 5];

        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 7;
        a[5] = 13;

        b[1] = 1;
        b[2] = 5;
        b[3] = 6;
        b[4] = 8;
        b[5] = 9;

        int lastAIndex = 5;

        for (int i=6; i <= n+1; i++) {
            a[i] = b[i-1] + b[i-3];
            b[i] = b[i-1] + 1;

            if (b[i] == a[lastAIndex]) {
                b[i]++;
                lastAIndex++;
            }
        }

        out.println(a[n]);
        out.println(b[n]);
    }
}