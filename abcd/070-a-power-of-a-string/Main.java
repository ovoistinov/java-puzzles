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
        int k = in.nextInt();

        if (k > 0) {
            out.print(multiplyString(s, k));
            return;
        } else if (k < 0) {
            k = Math.abs(k);
            String result = s.substring(0, s.length() / k);

            if (multiplyString(result, k).equals(s)) {
                out.print(result);
            } else {
                out.print("NO SOLUTION");
            }

            return;
        } else {
            throw new Error();
        }
    }

    private String multiplyString(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < n; i++) {
            sb.append(s);

            if (sb.length() > 1023) {
                return sb.toString().substring(0, 1023);
            }
        }

        return sb.toString();
    }
}