import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;
import static java.lang.Math.max;

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
        String s = in.nextLine();

        if (!validRadix(s)) {
            out.print(-1);
            return;
        }

        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        char lastChar = ch[ch.length - 1];
        int maxDigit;

        if ('0' <= lastChar && lastChar <= '9') {
            maxDigit = lastChar - '0';
        } else if ('A' <= lastChar && lastChar <= 'Z') {
            maxDigit = lastChar - 'A' + 10;
        } else {
            throw new AssertionError("Invalid character type.");
        }

        maxDigit;

        int radix = max(2, maxDigit + 1);

        out.print(radix);
    }

    private boolean validRadix(String input) {
        Pattern pattern = Pattern.compile("^[0-9A-Z]+$");
        return pattern.matcher(input).matches();
    }
}