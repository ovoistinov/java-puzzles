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
        int minOdd = in.nextInt();
        int maxEven = in.nextInt();
        int i = 3;

        while(in.hasNextInt()) {
            int n = in.nextInt();

            if (i % 2 == 0 && maxEven < n) {
                maxEven = n;
            } else if (i % 2 != 0 && minOdd > n) {
                minOdd = n;
            }

            i++;
        }

        out.print(maxEven + minOdd);
    }
}