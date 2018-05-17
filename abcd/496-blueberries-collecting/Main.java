import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.Math.max;

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
        int size = in.nextInt();
        size += 2;
        int[] bush = new int[size];

        for (int i=1; i < size - 1; i++) {
            bush[i] = in.nextInt();
        }

        bush[0] = bush[size - 2];
        bush[size - 1] = bush[1];

        int max = 0;
        for (int i=1; i < size - 1; i++) {
            int sum = getSum(bush, i);

            max = max(max, sum);
        }

        out.print(max);
    }

    private int getSum(int[] bush, int i) {
        return bush[i-1] + bush[i] + bush[i+1];
    }
}