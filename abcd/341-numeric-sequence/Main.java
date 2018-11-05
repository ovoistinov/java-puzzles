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

        if (n > 21) {
            int offset = n - 21;
            int firstDigit = offset % 8 + 2;
            int secondDigit = offset % 2;
            int secondDigitCount = offset / 8 + 2;

            out.print(firstDigit);

            for (int i=0; i < secondDigitCount; i++) {
                out.print(secondDigit);
            }
        } else {
            int result = 0;

            for (int i=1; i < n; i++) {
                result = calc(result);
            }

            out.print(result);
        }
    }

    private int calc(int a) {
        boolean[] used = new boolean[10];

        int temp = a;

        while(temp > 0) {
            used[temp % 10] = true;
            temp /= 10;
        }

        int b = a + 1;

        while(true) {
            if (containsDigits(b, used)) {
                b++;
                continue;
            } else {
                return b;
            }
        }
    }

    private boolean containsDigits(int a, boolean[] used) {
        while (a > 0) {
            if (used[a % 10]) return true;
            a /= 10;
        }

        return false;
    }
}