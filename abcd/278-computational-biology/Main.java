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
        String t = in.next();

        int currentIndex = 0;

        for (int ti=0; ti < t.length(); ti++) {
            if (t.charAt(ti) == s.charAt(currentIndex)) {
                currentIndex++;

                if (currentIndex == s.length()) {
                    out.print("YES");
                    return;
                }
            }
        }

        out.print("NO");
    }
}