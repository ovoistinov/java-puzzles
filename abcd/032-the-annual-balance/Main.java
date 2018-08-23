import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
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
        String s1 = in.next();
        String s2 = in.next();

        int sign1 = s1.startsWith("-") ? -1 : 1;
        int sign2 = s2.startsWith("-") ? -1 : 1;

        s1 = s1.replaceAll("\\D+", "");
        s2 = s2.replaceAll("\\D+", "");

        int res1 = sign1 > 0 ? toMax(s1) : toMin(s1);
        int res2 = sign2 > 0 ? toMin(s2) : toMax(s2);

        out.print(sign1*res1 - sign2*res2);
    }

    private int toMax(String s) {
        char[] c = s.toCharArray();

        Arrays.sort(c);
        reverse(c);

        return Integer.parseInt(String.valueOf(c));
    }

    private int toMin(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);

        if (c[0] == '0') {
            int i=1;
            while (i < c.length) {
                if (c[i] != '0') {
                    char temp = c[0];
                    c[0] = c[i];
                    c[i] = temp;
                    break;
                }
                i++;
            }
        }

        return Integer.parseInt(String.valueOf(c));
    }

    private void reverse(char[] c) {
        for(int i = 0; i < c.length / 2; i++)
        {
            char temp = c[i];
            c[i] = c[c.length - i - 1];
            c[c.length - i - 1] = temp;
        }
    }
}