import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private void solve(Scanner in, PrintWriter out) {
        int w = in.nextInt();
        int h = in.nextInt();

        long[] count = new long[h+1];
        Arrays.fill(count, 1);

        for (int i=w; i <= h; i++) {
            count[i] = count[i-1] + count[i-w];
        }

        out.print(count[h]);
    }

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
}
