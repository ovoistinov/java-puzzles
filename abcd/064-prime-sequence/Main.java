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
            solveSieveOfEratosthenes(in, out);
        }
    }

    private void solveSieveOfEratosthenes(Scanner in, PrintWriter out) {
        String primeSequence = getPrimeSequence(20219);

        int n = in.nextInt();

        for (int i=0; i < n; i++) {
            out.print(primeSequence.charAt(in.nextInt() - 1));
        }
    }

    private void solveSimple(Scanner in, PrintWriter out) {
        StringBuilder primeSequence = new StringBuilder();

        for (int i=2; i <= 20219; i++) {
            if (isPrime(i)) {
                primeSequence.append(i);
            }
        }

        int n = in.nextInt();

        for (int i=0; i < n; i++) {
            out.print(primeSequence.toString().charAt(in.nextInt() - 1));
        }
    }

    private boolean isPrime(int n) {
        for (int i=2; i <= n/i; i++) {
            if (n%i == 0) {
                return false;
            }
        }

        return n > 1;
    }

    private String getPrimeSequence(int n) {
        StringBuilder primeSequence = new StringBuilder();

        boolean[] isPrime = new boolean[n];
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

        for (int i=0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeSequence.append(i);
            }
        }

        return primeSequence.toString();
    }
}