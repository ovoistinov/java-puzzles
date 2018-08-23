import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.lang.Math;

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
        double q = in.nextDouble();

        long q1000 = (long) Math.round(q*1000);

        for (int i=0; i < n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            long d2 = x2*x2 + y2*y2;
            long d1 = x1*x1 + y1*y1;

            if (d2*1_000_000 > q1000*q1000*d1) {
                out.print("No");
                return;
            }
        }

        out.print("Yes");
    }

    private void solveWithDouble(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        double q = in.nextDouble();

        for (int i=0; i < n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            if (Math.sqrt(x2*x2 + y2*y2 ) > q*Math.sqrt(x1*x1 + y1*y1)*(1+1e-15)) {
                out.print("No");
                return;
            }
        }

        out.print("Yes");
    }
}