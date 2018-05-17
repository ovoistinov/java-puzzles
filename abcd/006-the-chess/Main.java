import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.Math.abs;

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
        String input = in.next();

        if (!inputFormatIsValid(input)) {
            out.print("ERROR");
            return;
        }

        out.print(isKnightMove(input));
    }

    private boolean inputFormatIsValid(String input) {
        Pattern pattern = Pattern.compile("[A-H][1-8]-[A-H][1-8]");
        return pattern.matcher(input).matches();
    }

    private String isKnightMove(String input) {
        char[] c = input.toCharArray();
        int h = abs(c[0] - c[3]);
        int v = abs(c[1] - c[4]);
        return h*h + v*v == 5 ? "YES" : "NO";
    }
}