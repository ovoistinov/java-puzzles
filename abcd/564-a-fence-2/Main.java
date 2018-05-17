import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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

        int[] len = new int[n];

        for (int i=0; i < n; i++) {
            len[i] = in.nextInt();
        }

        double maxS = 0;
        int maxA = 0;
        int maxB = 0;
        int maxC = 0;

        for (int a = 0; a < n; a++) {
            for (int b = a+1; b < n; b++) {
                for (int c = b+1; c < n; c++) {
                    if (len[a] + len[b] > len[c] &&
                        len[b] + len[c] > len[a] &&
                        len[a] + len[c] > len[b]) 
                    {
                        double square = calcSquare(len[a], len[b], len[c]);

                        if (square > maxS) {
                            maxS = square;
                            maxA = a;
                            maxB = b;
                            maxC = c;
                        }
                    }
                }
            }
        }

        if (maxS > 0) {
            out.printf("%.16f%n%d %d %d", Math.sqrt(maxS), maxA+1, maxB+1, maxC+1);
        } else {
            out.print("-1");
        }
    }

    private double calcSquare(double a, double b, double c) {
        double p = (a + b + c) / 2.0;
        return p*(p-a)*(p-b)*(p-c);
    }
}