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

        String result;

        if (isPalindrome(s)) {
            if (s.matches("(.)\\1*")) {
                result = "NO SOLUTION";
            } else {
                result = s.substring(1);
            }
        } else {
            result = s;
        }

        out.print(result);
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuffer(reverse(s)));
    }
}