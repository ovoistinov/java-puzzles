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
        int n = in.nextInt();

        // A number of combinations of m from n is n! / (m! * (n-m)!). We need all combinations from 2 to n, except singular
        // and zero salad so minus (n+1). According to one of their properties the sum of b.coefficients from 1 to n is equal
        // to 2**n. So the final formula is 2**n - (n+1).
        int result = (1 << n) - (n + 1);

        out.print(result);
    }
}