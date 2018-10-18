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
        String a = in.next();
        String b = in.next();

        String num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int r=getMinRadix(a, num); r <= 36; r++) {
            int converted = convert(a, r, num);

            if (converted == -1) {
                out.print(0);
                return;
            }

            if (converted == Integer.valueOf(b)) {
                out.print(r);
                return;
            }
        }

        out.print(0);
    }

    private int getMinRadix(String s, String num) {
        int maxChar = 0;

        for (int i=0; i < s.length(); i++) {
            maxChar = Math.max(maxChar, num.indexOf(s.charAt(i)));
        }

        return Math.max(2, maxChar + 1);
    }

    private int convert(String s, int radix, String num) {
        long result = 0;

        for (int i=0; i < s.length(); i++) {
            result = result*radix + num.indexOf(s.charAt(i));

            if (result > Integer.MAX_VALUE) return -1;
        }

        return (int) result;
    }
}