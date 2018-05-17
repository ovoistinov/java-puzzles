import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveByIteration(in, out);
        }
    }

    private void solveByIteration(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int period = in.nextInt();
        int result = 0;

        for (int i=1; i <= n; i++) {
            result = (result + period) % i;
        }

        result += 1;

        out.print(result);
    }

    private void solveByRecursion(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int period = in.nextInt();

        out.print(josephusRecursive(n, period));
    }

    private int josephusRecursive(int n, int period) {
        if (n == 1) {
            return 1;
        } else {
            int result = (josephusRecursive(n - 1, period) + period-1) % n + 1;
            return result;
        }
    }

    private void solveByEntireEmulation(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int period = in.nextInt();

        boolean[] alive = new boolean[n+1];
        Arrays.fill(alive, Boolean.TRUE);

        int pos = -1;

        for (int i=0; i < n-1; i++) {
            pos = nextAlive(alive, period, pos);
            alive[pos] = false;
        }

        int i = 0;
        while(alive[i] == false) {
            i++;
        }

        out.println(i+1);
    }

    private int nextAlive(boolean[] alive, int period, int pos) {
        for (int i=0; i < period; i++) {
            do {
                pos++;
                pos %= alive.length - 1;
            } while(alive[pos] != true);

        }
        return pos;
    }
}