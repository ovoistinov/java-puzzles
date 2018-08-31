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
        int n = in.nextInt();

        for (int i=0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int a = in.nextInt();

            // a == 1 covers all possible cases
            // a == 2 covers all even and odd cases for 3 <= x, y
            if ((a ==1 || a == 2) ||
            // 1 1 2 2
            // 6     3   a = 2
            // 6     3   cell count = 6
            // 5 5 4 4
                x%a == 0 && (y-2)%a == 0 ||
            // 6 1 1 2
            // 6     2   a = 2
            // 5     3   cell count = 6
            // 5 4 4 3
                y%a == 0 && (x-2)%a == 0 ||
            // 1 1 1 2
            // 4     2   a = 3
            // 4     2   cell ncount = 4
            // 4 3 3 3
                (x-1)%a == 0 && (y-1)%a == 0
            ) {
                out.print(1);
            } else {
                out.print(0);
            }
        }
    }
}