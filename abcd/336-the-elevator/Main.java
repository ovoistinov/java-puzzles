import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.Math.max;
import static java.lang.Math.min;

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
        String sequence = in.next();

        int current = 0;
        int max = current;
        int min = current;

        for (char c : sequence.toCharArray()) {
            int increment = c == '1' ? 1 : -1;
            current = current + increment;

            max = max(max, current);
            min = min(min, current);
        }

        out.print(max - min + 1);
    }
}