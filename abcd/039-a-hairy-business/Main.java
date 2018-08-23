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
        int[] price = new int[n];

        for (int i=0; i < n; i++) {
            price[i] = in.nextInt();
        }

        int sum = 0;
        int max = 0;

        for (int i=n-1; i >= 0; i--) {
            max = Math.max(max, price[i]);
            sum += max;
        }

        out.print(sum);
    }

}