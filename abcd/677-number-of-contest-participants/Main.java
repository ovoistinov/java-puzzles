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
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int k = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int d = in.nextInt();

        int dd = k*n*m*d;
        int dr = k*n*m - (k*n + k*m + n*m);

        if (dr <= 0 || dd % dr != 0) {
            out.print(-1);
            return;
        }

        int x = dd / dr;

        if (x % k == 0 
            && x % n == 0
            && x % m == 0) { 
            out.print(x);
        } else {
            out.print(-1);
        }
    }
}