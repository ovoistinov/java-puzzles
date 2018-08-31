import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        Locale.setDefault(Locale.US);

        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        double[] amount = new double[n];

        for (int i=0; i < n; i++) {
            amount[i] = in.nextInt();
        }

        double gAmount = in.nextInt();

        Arrays.sort(amount);

        for (int i=0; i < amount.length; i++) {
            if (amount[i] > gAmount) {
                gAmount = (amount[i] + gAmount)/2;
            }
        }

        out.printf("%.6f", gAmount);
    }
}