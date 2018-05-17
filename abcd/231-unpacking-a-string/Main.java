import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;
 
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
        char[] chars = s.toCharArray();

        CharPrinter printer = new CharPrinter(out);
        String repeatNumber = "";

        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                repeatNumber += c;
            } else {
                if (repeatNumber.isEmpty()) {
                    repeatNumber = "1";
                }

                printer.printCharNTimes(c, Integer.parseInt(repeatNumber));

                repeatNumber = "";
            }
        }
    }

    private static class CharPrinter {
        private static final int MAX_LINE_LENGTH = 40;
        private PrintWriter out;
        private int pos = 0;

        public CharPrinter(PrintWriter out) {
            this.out = out;
        }

        public void printCharNTimes(char c, int n) {
            int i = 1;

            while (i <= n) {
                out.print(c);

                i++;
                pos++;

                if (pos == MAX_LINE_LENGTH) {
                    out.println();
                    pos = 0;
                }
            }
        }
    }
}