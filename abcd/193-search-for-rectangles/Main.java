import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) throws Exception {
        int ySize = in.nextInt();
        int xSize = in.nextInt();
        int nRectangles = in.nextInt();

        int[] x_left = new int[nRectangles + 1];
        int[] x_right = new int[nRectangles + 1];
        int[] y_top = new int[nRectangles + 1];
        int[] y_bottom = new int[nRectangles + 1];

        for (int i=0; i <= nRectangles; i++) {
            x_left[i] = 200;
            y_bottom[i] = 200;
        }

        int count = 0;
        int index = 0;

        for (int y = ySize - 1; y >= 0; y--) {
            for (int x=0; x < xSize; x++) {
                int n = in.nextInt();

                if (n == 0) continue;

                x_left[n] = min(x_left[n], x);
                x_right[n] = max(x_right[n], x + 1);
                y_top[n] = max(y_top[n], y + 1);
                y_bottom[n] = min(y_bottom[n], y);

                count++;
                index = n;
            }
        }

        // Edge case, example:
        // 1 1 5
        // 3
        if (count == 1) {
            for (int i=0; i <= nRectangles; i++) {
                x_left[i] = x_left[index];
                x_right[i] = x_right[index];
                y_top[i] = y_top[index];
                y_bottom[i] = y_bottom[index];
            }
        }

        for (int i=1; i <= nRectangles; i++) {
            out.printf("%d %d %d %d\n", x_left[i], y_bottom[i], x_right[i], y_top[i]);
        }
    }

}