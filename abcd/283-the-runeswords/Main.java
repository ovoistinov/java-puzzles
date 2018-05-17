import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

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

        out.print(isRuneString(s) ? "Yes" : "No");
    }

    private boolean isRuneString(String s) {
        char[] chars = s.toCharArray();
        boolean isRune = isUpperCase(chars[0]) && isLowerCase(chars[chars.length - 1]);

        if (!isRune) {
            return false;
        }

        int letterCount = 0;

        for (char c : chars) {
            if (isLowerCase(c)) {
                letterCount++;

                if (letterCount > 4) {
                    isRune = false;
                    break;
                }
            } else {
                if (letterCount == 1) {
                    isRune = false;
                    break;
                }

                letterCount = 1;
            }
        }

        return isRune;
    }
}