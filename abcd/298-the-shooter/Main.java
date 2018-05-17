import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import static java.lang.Math.abs;
import static java.lang.Math.atan2;

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

        Set<String> directVectors = new HashSet<>();

        for (int i=0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            directVectors.add(calculateDirectVector(x, y));
        }

        out.print(directVectors.size());
    }

    private String calculateDirectVector(int x, int y) {
        int gcd = gcd(abs(x), abs(y));

        x = x / gcd;
        y = y / gcd;

        return String.format("%s %s", x, y);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    @Deprecated
    private void solveWithAtanNotGuaranteed(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        Set<Double> angles = new HashSet<>();

        for (int i=0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            angles.add(polarAngle(x, y));
        }
    }

    @Deprecated
    private double polarAngle(int x, int y) {
        return atan2(y, x);
    }
}