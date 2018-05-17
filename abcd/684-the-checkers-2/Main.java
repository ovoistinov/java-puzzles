import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.max;
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
        String p1 = in.next();
        String p2 = in.next();

        char h1 = p1.charAt(0);
        char v1 = p1.charAt(1);

        char h2 = p2.charAt(0);
        char v2 = p2.charAt(1);

        if ((v1 + h1) % 2 != 0) {
            throw new IllegalArgumentException("Start cell should be black.");
        }

        if (v2 > v1 
            && (v2 + h2) % 2 == 0
            && v2 >= v1 + abs(h2 - h1)) {
                out.print("YES");
        } else {
            out.print("NO");
        }
    }
}