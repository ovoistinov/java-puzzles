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

        int n3 = 0;
        int rem = n;

        while (rem % 5 != 0) {
            n3++;
            rem -= 3;
        }

        int n5 = (n - 3*n3) / 5;

        out.printf("%d %d", n5, n3);
    }
}