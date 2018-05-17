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
        String n = in.next();

        int count = 0;

        while(n.length() > 1) {
            count++;

            int sum = 0;
            char[] c = n.toCharArray();
            
            for (int i=0; i < n.length(); i++) {
                sum = sum + c[i] - '0';
            }

            n = "" + sum;
        };

        out.printf("%d %d", n.charAt(0) - '0', count);
    }
}