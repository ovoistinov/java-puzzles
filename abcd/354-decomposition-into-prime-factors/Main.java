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
        long n = in.nextLong();

        long i = 2;

        while (i <= n / i) {
            if (n % i == 0) {
                out.print(i);
                n /= i;

                out.print("*");
            } else {
                i++;
            }
        }

        out.print(n);
    }
}