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
        long n = in.nextLong();
        long k = in.nextLong();

        // Rooms on "nodes" = rooms on nodes except the central + 1 central: k*(n-1) + 1
        // Roms between nodes on edges (sequence like (0,1,2,3,...k)*(n-2)) = ((k-1)*k/2)*(n-2)

        long result = k*(n-1) + 1 + ((k-1)*k/2)*(n-2);

        out.print(result);
    }
}