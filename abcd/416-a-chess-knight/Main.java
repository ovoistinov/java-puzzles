import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
        String s = in.next();
        char[] ch = s.toCharArray();

        for (char h = 'a'; h <= 'h'; h++) {
            for (char v = '1'; v <= '8'; v++) {
                int ha = abs(ch[0] - h);
                int va = abs(ch[1] - v);

                if (ha*ha + va*va == 5) {
                    out.printf("%c%c%n", h, v);
                }
            }
        }

    }
}