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
        
        int[] profit = new int[n];
        int[] tax = new int[n];

        for (int i = 0; i < n; i++) {
            profit[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            tax[i] = in.nextInt();
        }

        int max = 0;
        int firmNumber = 0;

        for (int i= 0 ; i < n; i++) {
            int taxAmount = profit[i] * tax[i];

            if (taxAmount > max) {
                max = taxAmount;
                firmNumber = i;
            }
        }

        out.print(firmNumber + 1);
    }
}