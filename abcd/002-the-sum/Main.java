import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

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

        int sum;

        if (n > 0) {
            sum = (1 + n)*n/2;
        } else {
            // For negative numbers the standard formula should be adopted by applying (-1)*n and multiplying
            // the result on (-1): (1+(-1)*n)*(-1)*n/2*(-1) = (1-n)*n/2. And add 1 as a missing progression element.
            sum = (1 - n)*n/2 + 1;
        }

        out.print(sum);
    }
}