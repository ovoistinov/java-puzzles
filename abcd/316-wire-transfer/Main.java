import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Math;

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

        int max = (n / 107) * 100;
        int fee = (n / 107) * 7;
        int remainder = n % 107;

        if (remainder > 7) {
            max += remainder - 7;
            fee += 7;
        }

        out.printf("%d %d", max, fee);
    }
}