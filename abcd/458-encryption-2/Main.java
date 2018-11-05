import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        final String encoding = "cp866";

        try (
            Scanner in = new Scanner(new File("input.txt"), encoding);
            PrintWriter out = new PrintWriter(new File("output.txt"), encoding);
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[] rowSeq = new int[n];

        for (int i=0; i < rowSeq.length; i++) {
            rowSeq[i] = in.nextInt() - 1;
        }

        String s = in.next();

        String[] rows = new String[rowSeq.length];
        int pos = 0;
        int rowLen = 0;

        for (int i=0; i < rowSeq.length; i++) {
            if (rowSeq[i] < s.length() % n) {
                rowLen = s.length() / n + 1;
            } else {
                rowLen = s.length() / n;
            }

            rows[rowSeq[i]] = s.substring(pos, pos + rowLen);
            pos += rowLen;
        }

        int colNum = (s.length() + n - 1) / n;

        for (int j=0; j < colNum; j++) {
            for (int i=0; i < n; i++) {
                if (j < rows[i].length()) {
                    out.printf("%c", rows[i].toCharArray()[j]);
                }
            }
        }
    }
}