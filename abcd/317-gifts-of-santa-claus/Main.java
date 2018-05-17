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
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int w = in.nextInt();

        int count = 0;

        for (int ix=0; ix <= w/x; ix++) {
            for (int iy=0; iy <= (w - x*ix) / y; iy++) {
                if ((w - x*ix - y*iy) % z == 0) {
                    count++;
                }
            }

        }

        out.print(count);
    }
}