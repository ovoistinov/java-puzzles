import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

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

        s = reduceByOneDigit(s);
        s = reduceByOneDigit(s);

        out.print(s);
    }

    private String reduceByOneDigit(String s) {
        for (int i=1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                return new StringBuffer(s).deleteCharAt(i - 1).toString();
            }
        }

        return new StringBuffer(s).deleteCharAt(s.length() - 1).toString();
    }
}