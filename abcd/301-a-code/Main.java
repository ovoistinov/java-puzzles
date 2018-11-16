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
        int sum = in.nextInt();
        int num = in.nextInt();

        for (int i : getMax(sum, num)) out.printf("%d", i);

        out.print(" ");

        for (int i : getMin(sum, num)) out.printf("%d", i);
    }

    private int[] getMax(int sum, int num) {
        int[] max = new int[num];

        for (int i=0; i < num; i++) {
            max[i] = Math.min(9, sum);
            sum -= max[i];
        }

        return max;
    }

    private int[] getMin(int sum, int num) {
        int[] min = new int[num];

        sum--;

        for (int i=num - 1; i >= 0; i--) {
            min[i] = Math.min(9, sum);
            sum -= min[i];
        }

        min[0]++;

        return min;
    }
}
