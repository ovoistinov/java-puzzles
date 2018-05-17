import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        String word = in.next();

        for (int d=26; d > 0; d--) {
            String encoded = encodeString(s, d);

            if (encoded.contains(word)) {
                out.print(encoded);
                return;
            }
        }

        out.print("IMPOSSIBLE");
    }

    private String encodeString(String s, int denominator) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < s.length(); i++) {
            sb.append(encodeChar(s.charAt(i), denominator));
        }

        return sb.toString();
    }

    private char encodeChar(char c, int denominator) {
        return (char) ('A' + (c + denominator - 'A') % 26);
    }
}