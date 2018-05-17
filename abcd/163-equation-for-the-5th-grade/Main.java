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

        // a + b = c
        char a = s.charAt(0);
        char b = s.charAt(2);
        char c = s.charAt(4);
        char sign = s.charAt(1);
        int x;

        if (a == 'x' && sign == '+') {
            // x + b = c
            x = (c - '0')- (b - '0');
        } else if (a == 'x' && sign == '-') {
            // x - b = c
            x = (c - '0') + (b - '0');
        } else if (b == 'x' && sign == '+') {
            // a + x = c
            x = (c - '0') - (a - '0');
        } else if (b == 'x' && sign == '-') {
            // a - x = c
            x = (a - '0') - (c - '0');
        } else if (c == 'x' && sign == '+') {
            // a + b = x
            x = (a - '0') + (b - '0');
        } else if (c == 'x' && sign == '-') {
            // a - b = x
            x = (a - '0') - (b - '0');
        } else {
            throw new AssertionError("Invalid equation format.");
        }

        out.print(x);
    }
}