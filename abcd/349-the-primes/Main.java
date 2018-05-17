import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.util.Arrays.fill;

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
        int first = in.nextInt();
        int last = in.nextInt();

        boolean[] isPrime = getPrimes(last);
        boolean primeFound = false;

        for (int i=first; i <= last; i++) {
            if (isPrime[i]) {
                out.println(i);
                primeFound = true;
            }
        }

        if (!primeFound) {
            out.print("Absent");
        }
    }

    private boolean[] getPrimes(int last) {
        boolean[] isPrime = new boolean[last + 1];
        fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i*i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j < isPrime.length; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}