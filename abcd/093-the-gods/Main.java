import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.valueOf;
import static java.lang.String.format;

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
        int gSize = in.nextInt();
        String[] godNames = new String[gSize];

        for (int i=0; i < gSize; i++) {
            godNames[i] = in.next();
        }

        int sSize = in.nextInt();
        String[] names = new String[sSize];

        for (int i=0; i < sSize; i++) {
            names[i] = in.next();
        }

        for (int i=0; i < godNames.length; i++) {
            int count = 0;

            for (int j=0; j < names.length; j++) {
                if (suspiciousName(names[j], godNames[i])) {
                    count++;
                }
            }

            out.printf("%d ", count);
        }
    }

    private boolean suspiciousName(String name, String godName) {
        if (name.length() != godName.length()) {
            return false;
        }

        int mismatchedLetters = 0;

        for (int i=0; i < name.length(); i++) {
            if (name.charAt(i) != godName.charAt(i)) {
                mismatchedLetters++;
            }
        }

        return mismatchedLetters == 1;
    }
}