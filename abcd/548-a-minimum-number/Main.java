import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.StringBuilder;

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
        String n1 = in.next() + "A";
        String n2 = in.next() + "A";

        StringBuilder result = new StringBuilder();

        while (n1.length() > 1 || n2.length() > 1) {
            if (n1.compareTo(n2) < 0) {
                result.append(n1.charAt(0));
                n1 = n1.substring(1);
            } else {
                result.append(n2.charAt(0));
                n2 = n2.substring(1);
            }
        }

        out.print(result.toString());
    }
}
