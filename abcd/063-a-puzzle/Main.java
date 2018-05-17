import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.sqrt;

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
        int a = 1;
        int b = -1*in.nextInt();
        int c = in.nextInt();

        int d = b*b - 4*a*c;

        int x1 = (-b - (int) sqrt(d)) / (2*a);
        int x2 = (-b + (int) sqrt(d)) / (2*a);

        out.printf("%d %d", x1, x2);
    }
}