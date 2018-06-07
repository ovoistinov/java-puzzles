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
        int x = in.nextInt();
        int y = in.nextInt();

        int[] dp = new int[21];

        for (int i=1; i <= 32767; i++) {
        	for (int j=1; j <= i; j++) {
        		dp[1] = i;
        		dp[2] = j;

        		for (int k=3; k <= x; k++) {
        			dp[k] = dp[k-1] + dp[k-2];
        		}

        		if (dp[x] == y) {
        			out.printf("%d %d", i, j);
        			return;
        		}
        	}
        }

        throw new Error("No solution found.");
    }
}