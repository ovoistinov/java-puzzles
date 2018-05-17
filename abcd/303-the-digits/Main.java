import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.max;

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

        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i < n.length(); i++) {
            StringBuffer temp = new StringBuffer();
            temp.append(n.substring(0, i));
            temp.append(n.substring(i+1, n.length()));

            maxSum = max(maxSum, plusMinusSum(temp.toString()));
        }

        out.print(maxSum);
    }

    private int plusMinusSum(String n) {
        int sum = 0;

        for (int i=0; i < n.length(); i++) {
            if (i % 2 == 0) {
                sum += n.charAt(i) - '0';
            } else {
                sum -= n.charAt(i) - '0';
            }
        }

        return sum;
    }
}