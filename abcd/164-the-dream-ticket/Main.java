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
        String s = in.next();

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());

            if (calcDigitalRoot(left) == calcDigitalRoot(right)) {
                out.print("YES");
                return;
            }
        }

        out.print("NO");
    }

    private int calcDigitalRoot(String s) {
        while(true) {
            int sum = 0;

            for (char c : s.toCharArray()) {
                sum += c - '0';
            }

            if (sum >= 0 && sum <= 9) {
                return sum;
            } else {
                s = "" + sum;
            }
        }
    }
}