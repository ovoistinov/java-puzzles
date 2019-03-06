import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    // Runtime: O(n^3)
    // Memory: O(n^3)
    private void solve(Scanner in, PrintWriter out) {
        int size = in.nextInt();
        int steps = in.nextInt();

        // DP structure:
        // 
        // count[i][j][0] - initial map. Should be immutable.
        // count[i][j][1] - count of possible entries for each cell on 1st step
        // ...
        // count[i][j][k] - count of possible entries for each cell on Kth step
        //
        int[][][] count = new int[size+2][size+2][steps+1];

        for (int i=1; i <= size; i++) {
            String s = in.next();
            for (int j=1; j <= size; j++) {
                count[i][j][0] = s.charAt(j-1) - '0';
            }
        }

        // Initial state for the 1st layer:
        //
        // 0x0
        // x00
        // 000
        if (count[2][1][0] == 0) count[2][1][1] = 1;
        if (count[1][2][0] == 0) count[1][2][1] = 1;

        for (int k=2; k <= steps; k++) {
            for (int i=1; i <= size; i++) {
                for (int j=1; j <= size; j++) {
                    if (count[i][j][0] == 0) {
                        count[i][j][k] += count[i-1][j][k-1];
                        count[i][j][k] += count[i+1][j][k-1];
                        count[i][j][k] += count[i][j-1][k-1];
                        count[i][j][k] += count[i][j+1][k-1];
                    }
                }
            }
        }

        out.print(count[size][size][steps]);
    }

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
}
