import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
        int width = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        String[] line = new String[n];

        for (int i=0; i < n; i++) {
            line[i] = trimWhitespaces(in.nextLine());

            if (line[i].length() > width) {
                out.print("Impossible.");
                return;
            }
        }

        for (int i=0; i < line.length; i++) {
            int prefixLength = (width - line[i].length()) / 2;
            int suffixLength = width - prefixLength - line[i].length();

            out.print(getSpaces(prefixLength));
            out.print(line[i]);
            out.print(getSpaces(suffixLength));
            out.println();
        }
    }

    private String trimWhitespaces(String s) {
        int start = 0;

        while(start < s.length() - 1 && s.charAt(start) == ' ') {
            start++;
        }

        int end = s.length() - 1;

        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        return s.substring(start, end + 1);
    }

    private String getSpaces(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < n; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}