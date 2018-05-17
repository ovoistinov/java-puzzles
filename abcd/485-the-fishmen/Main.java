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
        int k = in.nextInt();

        // The max number of fish (if fishment throw out zero fish each time) is n*n.
        // But they throw the fish out (n-1) times, so the result would be 
        // n*n - k*(n-1), where k is the number of the thrown out fish

        int nFishMax = 1;

        for (int i=0; i < n; i++) {
            nFishMax *= n;
        }

        int nFishThrownAway = k*(n-1);
        int nFish = nFishMax - nFishThrownAway;

        out.print(nFish);
    }
}