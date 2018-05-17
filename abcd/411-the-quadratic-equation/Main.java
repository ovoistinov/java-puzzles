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
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double[] root;

        if (a == 0 && b == 0 && c == 0) {
            out.print(-1);
            return;
        } else if (a == 0 && b == 0) { // c != 0
            root = new double[0];
        } if (a == 0) { // b != 0
            root = new double[1];
            root[0] = -c/b;
        } else {
            double d = b*b - 4*a*c;

            if (d > 0) {
                root = new double[2];
                root[0] = (-b - Math.sqrt(d))/(2*a);
                root[1] = (-b + Math.sqrt(d))/(2*a);
            } else if (d < 0) {
                root = new double[0];
            } else {
                root = new double[1];
                root[0] = (-1)*b/(2*a);
            }
        }

        out.println(root.length);

        for (int i=0; i < root.length; i++) {
            out.printf("%.6f%n", root[i]);
        }
    }
}