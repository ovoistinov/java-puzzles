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
        int distance = in.nextInt();
        int steps = in.nextInt();

        int[][] dp = new int[40][40];

        dp[0][0] = 1;

        for (int i=0; i < steps; i++) {
            for (int j=steps; j >= 0; j--) {
                if (i > 0 && j > 0) dp[i][j] += dp[i-1][j-1];
                if (i > 0) dp[i][j] += dp[i-1][j+1];
            }
        }

        out.print(dp[steps - 1][distance - 1]);
    }

    private void solveWithRecursion(Scanner in, PrintWriter out) {
        int distance = in.nextInt();
        int steps = in.nextInt();

        int[][] cache = new int[39][39];
        prepareCache(cache);

        out.print(helper(distance, steps, 0, cache));
    }

    private void prepareCache(int[][] cache) {
        for (int i=0; i < cache.length; i++) {
            for (int j=0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
    }

    private int helper(int distance, int steps, int increment, int[][] cache) {
        if (steps == 0 && distance == 0 && increment == -1) {
            return 1;
        } else if (distance == 0 || 
                distance > 37 ||
                steps == 0 ||
                steps > 37) {
            cache[distance][steps] = 0;
            return 0;
        }

        if (cache[distance][steps] != -1) {
            return cache[distance][steps];
        }

        int dp1 = cache[distance+1][steps-1];
        int dp2 = cache[distance-1][steps-1];

        if (dp1 == -1) {
            dp1 = helper(distance+1, steps-1, 1, cache);
            cache[distance+1][steps-1] = dp1;
        }

        if (dp2 == -1) {
            dp2 = helper(distance-1, steps-1, -1, cache);
            cache[distance-1][steps-1] = dp2;
        }

        return dp1 + dp2;
    }
}