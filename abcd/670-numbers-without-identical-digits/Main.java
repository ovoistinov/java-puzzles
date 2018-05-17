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

        int i = 1;
        int found = 0;

        while (true) {
            found += hasIdenticalDigits(i) ? 0 : 1;

            if (found == n) {
                break;
            }

            i++;
        }

        out.print(i);
    }

    private boolean hasIdenticalDigits(int n) {
        if (n <= 10) {
            return false;
        }

        boolean[] used = new boolean[10];

        while (n > 0) {
            int lastDigit = n % 10;

            if (used[lastDigit]) {
                return true;
            } else {
                used[lastDigit] = true;
            }

            n = n / 10;
        }

        return false;
    }
}