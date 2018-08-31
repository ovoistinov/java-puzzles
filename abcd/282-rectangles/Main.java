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
        int w = in.nextInt();
        int h = in.nextInt();

        out.print(calcWithFormula(w, h));
    }

    private long calcWithFormula(int w, int h) {
        long sumW = (1 + w)*w/2;
        long sumH = (1 + h)*h/2;

        return sumW*sumH;
    }

    private long calcWithLoops(int w, int h) {
        long count = 0;

        for (int i=0; i < w; i++) {
            for (int j=0; j < h; j++) {
                count += (h - j)*(w - i);
            }
        }

        return count;
    }
}