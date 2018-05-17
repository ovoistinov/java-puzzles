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
        int scale = in.nextInt();

        int sum = 0;
        int mul = 1;

        while(n > 0) {
            sum += n % scale;
            mul *= n % scale;
            n /= scale;
        }

        out.print(mul - sum);
    }
}