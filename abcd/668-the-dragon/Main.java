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
        int heads = in.nextInt();
        int tails = in.nextInt();

        // cut 1 head - 1 new head grows
        // cut 2 heads - nothing grows (*)
        // cut 1 tail - 2 new grows
        // cut 2 tails - 1 new head grows

       if (heads%2 != 0 && tails == 0) {
            out.print(-1);
            return;
        }

        int hits = 0;

        while(true) {
            if (tails%2 == 0 && (heads + tails/2)%2 == 0) {
                hits += tails/2 + (heads + tails/2)/2;
                break;
            } else {
                hits++;
                tails++;
            }
        }

        out.print(hits);
    }
}