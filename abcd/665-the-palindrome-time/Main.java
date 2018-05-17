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
        in.useDelimiter("\\:|\\s+");

        int h = in.nextInt();
        int m = in.nextInt();

        while(true) {
            m++;

            if (m == 60) {
                m = 0;
                h++;
            }

            if (h == 24) {
                h = 0;
            }

            if (h/10 == m%10 && h%10 == m/10) {
                out.printf("%02d:%02d", h, m);
                break;
            }
        }
    }
}