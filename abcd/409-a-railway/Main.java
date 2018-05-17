import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        Locale.setDefault(Locale.US);

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

        for (int i=0; i < p.length; i++) {
            p[i] = in.nextInt();
        }

        double area = 0;

        for (int i=1; i < p.length; i++) {
            area += 1 * (p[i-1] + p[i]) / 2.0;
        }

        out.printf("%.10f", area / (n - 1));
    }
}