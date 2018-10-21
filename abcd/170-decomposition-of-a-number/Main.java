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
        int s = in.nextInt();

        // Begin with arithmetic progression sum:
        // S = n*(a1 + an)/2;
        // where n and a1 are unknown and an = a1 + n - 1. S is given in the input. 
        // Use that info in the formula:
        // S = n*(2*a1 + n-1)/2. Multiply by 2 and simplify:
        // 2*S = n*2*a1 + n*(n-1). Derive a1 from that formula:
        // a1 = (2*S - n*(n-1)) / 2*n
        // Now iterate until we found an integer result.

        int max = 1;

        for (int n=2; 2*s - n*(n-1) >= 2*n; n++) {
            if ((2*s - n*(n-1)) % (2*n) == 0) {
                max = Math.max(max, n);
            }
        }

        out.print(max);
    }
}