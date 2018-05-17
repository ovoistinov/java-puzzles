import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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
        int n = in.nextInt();

        int upper = n;
        int lower = n;

        while(true) {
            if (isDouble(lower)) {
                out.print(lower);
                return;
            }

            if (isDouble(upper)) {
                out.print(upper);
                return;
            }

            upper++;
            lower--;
        }
    }

    private boolean isDouble(int n) {
        String s = "" + n;

        Set<Character> chars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        return chars.size() <= 2;
    }
}