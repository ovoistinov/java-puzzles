import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

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
        int k = in.nextInt();

        int w = 1;
        int h = 1;
        int minBeauty = k;
        
        for (int i = 1; i*i <= k; i++) {
            int j = k / i;
            int beauty = abs(i - j) + k - i*j;

            if (beauty < minBeauty) {
                minBeauty = beauty;
                w = i;
                h = j;
            }
        }

        out.printf("%d %d", w, h);
    }
}